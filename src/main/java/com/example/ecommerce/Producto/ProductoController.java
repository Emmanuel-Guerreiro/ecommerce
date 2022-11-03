package com.example.ecommerce.Producto;

import com.example.ecommerce.Base.BaseController;
import com.example.ecommerce.Producto.DTO.DTOCreateProducto;

public interface ProductoController extends BaseController<Producto, Long> {

    public Producto save(DTOCreateProducto entity) throws Exception;

}
