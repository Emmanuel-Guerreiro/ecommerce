package com.example.ecommerce.Carrito;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ecommerce.Base.BaseController;

public interface CarritoController extends BaseController<Carrito, Long> {

    // todo: Set as DTO
    DetalleCarrito addItem(@PathVariable Long idCarrito,
            @RequestParam Long item,
            @RequestParam int cantidad) throws Exception;

}
