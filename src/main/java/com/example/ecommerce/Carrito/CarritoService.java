package com.example.ecommerce.Carrito;

import com.example.ecommerce.Base.BaseService;

public interface CarritoService extends BaseService<Carrito, Long> {
    // todo: Set as DTO
    DetalleCarrito addItem(Long idCarrito,
            Long idItem,
            int cantidad) throws Exception;
}
