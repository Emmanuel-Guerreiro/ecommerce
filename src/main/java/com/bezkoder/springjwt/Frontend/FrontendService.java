package com.bezkoder.springjwt.Frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.Carrito.Carrito;
import com.bezkoder.springjwt.Carrito.CarritoServiceImpl;
import com.bezkoder.springjwt.Carrito.DetalleCarrito;
import com.bezkoder.springjwt.Frontend.DTO.DTOCarritoUI;
import com.bezkoder.springjwt.Frontend.DTO.DTOProductoUI;
import com.bezkoder.springjwt.Producto.Producto;
import com.bezkoder.springjwt.Producto.ProductoService;
import com.bezkoder.springjwt.Producto.ProductoServiceImpl;

@Service
public class FrontendService {

    ProductoService productoService;
    CarritoServiceImpl carritoService;

    @Autowired
    public FrontendService(ProductoServiceImpl productoService, CarritoServiceImpl carritoService) {
        this.productoService = productoService;
        this.carritoService = carritoService;
    }

    public DTOProductoUI buildProductData(Long id) throws Exception {
        Producto producto = productoService.findById(id);
        List<Producto> similares = productoService.findSimilar(producto);

        System.out.println("Similares   ");
        System.out.println(similares.size());
        DTOProductoUI dto = DTOProductoUI.builder()
                .imagen(producto.getImagen())
                .nombre(producto.getNombre())
                .precio(producto.getPrecio())
                .maxCant(producto.getStock())
                .similares(similares)
                .build();

        return dto;
    }

    DTOCarritoUI buildCarritoData(Long id) throws Exception {
        Carrito c = carritoService.findByUsuarioId(id);

        float total = 0;
        for (DetalleCarrito d : c.getDetalles()) {
            float precioItem = d.getProducto().getPrecio() * d.getCantidad();
            System.out.println(precioItem);
            total += precioItem;
        }

        DTOCarritoUI dto = DTOCarritoUI.builder()
                .total(total)
                .detalles(c.getDetalles())
                .cantidadItems(c.getDetalles().size())
                .build();

        return dto;
    }

}
