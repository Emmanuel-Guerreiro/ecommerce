package com.example.ecommerce.Producto;

import com.example.ecommerce.Base.BaseController;
import com.example.ecommerce.Producto.DTO.DTOCreateProducto;
import org.springframework.ui.Model;

import java.util.List;

public interface ProductoController extends BaseController<Producto, Long> {

    public Producto save(DTOCreateProducto entity) throws Exception;

}
