package com.bezkoder.springjwt.Producto;

import java.util.List;

import com.bezkoder.springjwt.Base.BaseService;
import com.bezkoder.springjwt.Producto.DTO.DTOCreateProducto;

public interface ProductoService extends BaseService<Producto, Long> {

    public Producto save(DTOCreateProducto producto_nuevo) throws Exception;

    public List<Producto> findSimilar(Producto p);
}
