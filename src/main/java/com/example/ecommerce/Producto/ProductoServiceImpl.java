package com.example.ecommerce.Producto;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Base.BaseServiceImpl;
import com.example.ecommerce.Categoria.Categoria;
import com.example.ecommerce.Categoria.CategoriaServiceImpl;
import com.example.ecommerce.Producto.DTO.DTOCreateProducto;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Long, ProductoRepository>
        implements ProductoService {
    CategoriaServiceImpl categoriaService;

    @Autowired
    public ProductoServiceImpl(ProductoRepository repository, CategoriaServiceImpl categoriaService) {
        super(repository);
        this.categoriaService = categoriaService;
    }

    // Todo: Mapper deberia llegar por DI
    public Producto save(DTOCreateProducto producto_nuevo) {
        ModelMapper mapper = new ModelMapper();
        Producto producto = mapper.map(producto_nuevo, Producto.class);

        Categoria categoria = categoriaService.findOrCreate(producto_nuevo.getCategoria());
        producto.setCateogria(categoria);

        return repository.save(producto);

    }

    public List<Producto> findAllByCategory(Long categoria) {
        if (categoria == null) {
            return repository.findAll();
        }
        return repository.findByCateogriaId(categoria);

    }
}
