package com.bezkoder.springjwt.Carrito;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.Base.BaseServiceImpl;
import com.bezkoder.springjwt.Carrito.DTO.DTOAddItem;
import com.bezkoder.springjwt.Carrito.DTO.DTOCreateCarrito;
import com.bezkoder.springjwt.Producto.Producto;
import com.bezkoder.springjwt.Producto.ProductoService;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.security.services.UserService;
import java.util.ArrayList;
import java.util.List;

@Service

public class CarritoServiceImpl extends BaseServiceImpl<Carrito, Long, CarritoRepository> {

    ProductoService productoService;
    @Autowired
    DetalleCarritoRepository repoDetalle;
    UserService userService;
    @Autowired
    CarritoRepository repo;

    @Autowired
    CarritoServiceImpl(CarritoRepository repository, ProductoService productoService,
            UserService userService) {
        super(repository);
        this.productoService = productoService;
        this.userService = userService;
    }

    // ? Cuando se implemente la autenticacion. Hay que reemplazar
    // ? el idCarrito por data de autentiocacion
    public DetalleCarrito addItem(long idUser, DTOAddItem dtoAdd) throws Exception {

        Carrito carrito = this.findOrCreate(idUser);
        Producto producto = this.productoService.findById(dtoAdd.getProducto());

        if (dtoAdd.getCantidad() > producto.getStock() || dtoAdd.getCantidad() < 0) {
            throw new Exception("Non valid stock amount");
        }

        DetalleCarrito dCarrito = DetalleCarrito.builder()
                .cantidad(dtoAdd.getCantidad())
                .producto(producto)
                .build();
        
        
        //en caso de ya existir un detalle para ese producto, se acumulan las cantidades
        List<DetalleCarrito> detalles = carrito.getDetalles();
        for(DetalleCarrito d : detalles){
            if(d.getProducto() == dCarrito.getProducto()){
                d.setCantidad(d.getCantidad() + dCarrito.getCantidad());
                carrito.setDetalles(detalles);
                this.update(carrito.getId(), carrito);    
                return dCarrito;
            }
        }
        
        carrito.addDettale(dCarrito);
        this.update(carrito.getId(), carrito);
        return dCarrito;
    };

    // Todo: manejar el tema del usuario
    Carrito findOrCreate(Long id) throws Exception {
        Optional<Carrito> opt = this.repository.findByUsuarioId(id);
        if (!opt.isPresent()) {
            return this.save(new Carrito());
        }
        return opt.get();
    }

    // 1 Cliente solo puede tener un carrito, si ya lo tiene. Se devuelve el que
    // esta
    Carrito save(DTOCreateCarrito dto) throws Exception {

        Optional<Carrito> optCarrito = repository.findByUsuarioId(dto.getCliente());

        if (optCarrito.isPresent())
            return optCarrito.get();

        Carrito c = new Carrito();
        User client = userService.findById(dto.getCliente());

        c.setUsuario(client);
        return repository.save(c);
    }
    
    public Carrito findByUsuarioId(Long id){
        return repo.findByUsuarioId(id).get();
    }
    
    public void deleteDetalleById(Long id){
        this.repoDetalle.deleteFromJoinTable(id);
        this.repoDetalle.deleteById(id);
    }
}

