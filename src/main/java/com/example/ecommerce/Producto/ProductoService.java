package com.example.ecommerce.Producto;

import com.example.ecommerce.Base.BaseService;
import com.example.ecommerce.Producto.DTO.DTOCreateProducto;

public interface ProductoService extends BaseService<Producto, Long> {

    public Producto save(DTOCreateProducto producto_nuevo);

}
