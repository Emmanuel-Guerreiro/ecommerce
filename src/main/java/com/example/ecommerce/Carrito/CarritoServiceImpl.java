package com.example.ecommerce.Carrito;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Base.BaseServiceImpl;
import com.example.ecommerce.Producto.Producto;
import com.example.ecommerce.Producto.ProductoService;

@Service

public class CarritoServiceImpl extends BaseServiceImpl<Carrito, Long, CarritoRepository> {

    ProductoService productoService;

    @Autowired
    CarritoServiceImpl(CarritoRepository repository, ProductoService productoService) {
        super(repository);
        this.productoService = productoService;
    }

    // ? Cuando se implemente la autenticacion. Hay que reemplazar
    // ? el idCarrito por data de autentiocacion
    public DetalleCarrito addItem(Long idCarrito,
            Long idItem,
            int cantidad) throws Exception {

        Carrito carrito = this.findOrCreate(idCarrito);
        Producto producto = this.productoService.findById(idItem);

        if (cantidad > producto.getStock() || cantidad < 0) {
            throw new Exception("Non valid stock amount");
        }

        DetalleCarrito dCarrito = DetalleCarrito.builder().cantidad(cantidad).producto(producto).build();
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

}
