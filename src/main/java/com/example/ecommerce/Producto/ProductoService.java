package com.example.ecommerce.Producto;

import java.util.List;

import com.example.ecommerce.Base.BaseService;
import com.example.ecommerce.Producto.DTO.DTOCreateProducto;

public interface ProductoService extends BaseService<Producto, Long> {

    public Producto save(DTOCreateProducto producto_nuevo) throws Exception;

    public List<Producto> findSimilar(Producto p);
}
