package com.example.ecommerce.Carrito;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Base.BaseServiceImpl;
import com.example.ecommerce.Carrito.DTO.DTOAddItem;
import com.example.ecommerce.Carrito.DTO.DTOCreateCarrito;
import com.example.ecommerce.Cliente.Cliente;
import com.example.ecommerce.Cliente.ClienteServiceImpl;
import com.example.ecommerce.Producto.Producto;
import com.example.ecommerce.Producto.ProductoService;

@Service

public class CarritoServiceImpl extends BaseServiceImpl<Carrito, Long, CarritoRepository> {

    ProductoService productoService;
    ClienteServiceImpl clienteService;

    @Autowired
    CarritoServiceImpl(CarritoRepository repository, ProductoService productoService,
            ClienteServiceImpl clienteService) {
        super(repository);
        this.productoService = productoService;
        this.clienteService = clienteService;
    }

    // ? Cuando se implemente la autenticacion. Hay que reemplazar
    // ? el idCarrito por data de autentiocacion
    public DetalleCarrito addItem(long idCarrito, DTOAddItem dtoAdd) throws Exception {

        Carrito carrito = this.findOrCreate(idCarrito);
        Producto producto = this.productoService.findById(dtoAdd.getProducto());

        if (dtoAdd.getCantidad() > producto.getStock() || dtoAdd.getCantidad() < 0) {
            throw new Exception("Non valid stock amount");
        }

        DetalleCarrito dCarrito = DetalleCarrito.builder()
                .cantidad(dtoAdd.getCantidad())
                .producto(producto)
                .build();

        carrito.addDettale(dCarrito);

        this.update(idCarrito, carrito);

        return dCarrito;
    };

    // Todo: manejar el tema del usuario
    Carrito findOrCreate(Long id) throws Exception {
        Optional<Carrito> opt = this.repository.findById(id);
        if (!opt.isPresent()) {
            return this.save(new Carrito());
        }
        return opt.get();
    }

    // 1 Cliente solo puede tener un carrito, si ya lo tiene. Se devuelve el que
    // esta
    Carrito save(DTOCreateCarrito dto) throws Exception {

        Optional<Carrito> optCarrito = repository.findByClienteId(dto.getCliente());

        if (optCarrito.isPresent())
            return optCarrito.get();

        Carrito c = new Carrito();
        Cliente client = clienteService.findById(dto.getCliente());

        c.setCliente(client);
        return repository.save(c);
    }

}
