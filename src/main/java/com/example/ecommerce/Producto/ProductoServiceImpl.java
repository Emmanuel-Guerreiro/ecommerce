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
    public ProductoRepository repo;

    @Autowired
    public ProductoServiceImpl(ProductoRepository repository, CategoriaServiceImpl categoriaService) {
        super(repository);
        this.categoriaService = categoriaService;
    }

    // Todo: Mapper deberia llegar por DI
    @Override
    public Producto save(DTOCreateProducto producto_nuevo) throws Exception {
        try {
            ModelMapper mapper = new ModelMapper();
            System.out.println(producto_nuevo.toString());
            Producto producto = mapper.map(producto_nuevo, Producto.class);

            Categoria categoria = categoriaService.findByNameOrCreate(producto_nuevo.getCategoria());
            producto.setCateogria(categoria);

            // System.out.println("-------------------Debugeando---------------------");
            // IndireccionImageStorage storage = new IndireccionImageStorage();
            // String direccionImg = storage.uploadImage(producto_nuevo.getImagen());
            // System.out.println("-------------------Debugeando---------------------");
            // producto.setImagen(direccionImg);
            return repository.save(producto);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public List<Producto> findAllByCategory(Long categoria) {
        if (categoria == null) {
            return repository.findAll();
        }
        return repository.findByCateogriaId(categoria);

    }

    // Busca similares pero no el mismo item
    public List<Producto> findSimilar(Categoria categoria) {
        List<Producto> similares = repository.findByCateogriaId(categoria.getId());

        similares.removeIf(p -> p.getCateogria().getId() == categoria.getId());

        return similares;
    }

    @Override
    public List<Producto> findByFilter(String filter) {
        return this.repo.findByFilter(filter);
    }
}
