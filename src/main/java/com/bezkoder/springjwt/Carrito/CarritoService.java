package com.bezkoder.springjwt.Carrito;

import com.bezkoder.springjwt.Base.BaseService;

public interface CarritoService extends BaseService<Carrito, Long> {
    // todo: Set as DTO
    DetalleCarrito addItem(Long idCarrito,
            Long idItem,
            int cantidad) throws Exception;
    
    Carrito findByUsuarioId(Long id);
}
