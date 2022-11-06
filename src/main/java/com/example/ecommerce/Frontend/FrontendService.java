package com.example.ecommerce.Frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Frontend.DTO.DTOProductoUI;
import com.example.ecommerce.Producto.Producto;
import com.example.ecommerce.Producto.ProductoService;

@Service
public class FrontendService {

    ProductoService productoService;

    @Autowired
    public FrontendService(ProductoService productoService) {
        this.productoService = productoService;
    }

    public DTOProductoUI buildProductData(Long id) throws Exception {
        Producto producto = productoService.findById(id);
        List<Producto> similares = productoService.findSimilar(producto.getCateogria());

        DTOProductoUI dto = DTOProductoUI.builder()
                .imagen("https://placekitten.com/400/400")
                .nombre(producto.getNombre())
                .precio(producto.getPrecio())
                .maxCant(producto.getStock())
                .similares(similares)
                .build();

        return dto;
    }

}
