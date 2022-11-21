package com.bezkoder.springjwt.Carrito;

import com.bezkoder.springjwt.Base.BaseController;

public interface CarritoController extends BaseController<Carrito, Long> {
public void deleteDetalleById(Long id);
}
