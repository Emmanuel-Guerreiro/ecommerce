package com.example.ecommerce.Producto;

import java.util.List;

import com.example.ecommerce.Base.BaseService;
import com.example.ecommerce.Categoria.Categoria;
import com.example.ecommerce.Producto.DTO.DTOCreateProducto;

public interface ProductoService extends BaseService<Producto, Long> {

    public Producto save(DTOCreateProducto producto_nuevo);

    public List<Producto> findSimilar(Categoria c);
}
