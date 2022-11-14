package com.example.ecommerce.Producto;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Base.BaseServiceImpl;
import com.example.ecommerce.Categoria.Categoria;
import com.example.ecommerce.Categoria.CategoriaServiceImpl;
import com.example.ecommerce.ImageStorage.IndireccionImageStorage;
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
            // Convierto los campos basicos del dto a objeto
            ModelMapper mapper = new ModelMapper();
            Producto producto = mapper.map(producto_nuevo, Producto.class);
            System.out.println(producto_nuevo.getCategoria());
            // Cargo la categoria (Me aseguro que exista o la creo)
            Categoria categoria = categoriaService.findByNameOrCreate(producto_nuevo.getCategoria());
            producto.setCateogria(categoria);

            // La imagen se va a un microservicio de nodejs y me devuelve la url de un
            // storage de firebase
            IndireccionImageStorage storage = new IndireccionImageStorage();
            String direccionImg = storage.uploadImage(producto_nuevo.getImagen(), producto.getNombre());
            producto.setImagen(direccionImg);

            return repository.save(producto);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    // Todo: Add pagination

    public List<Producto> findWithFilters(
            String nombre, Long categoria
    // ProductoFilterEnum filter, Object value
    ) {

        if (nombre == null && categoria == null)
            return repository.findAll();
        // if (filter == ProductoFilterEnum.CATEGORIA)
        // return this.findAllByCategory((Long) value);
        // if (filter == ProductoFilterEnum.NOMBRE)
        // return this.findAllByName((String) value);

        return repository.findByNombreOrCateogriaId(nombre, categoria);
    }

    public List<Producto> findAllByCategory(Long categoria) {
        if (categoria == null) {
            return repository.findAll();
        }
        return repository.findByCateogriaId(categoria);

    }

    public List<Producto> findAllByName(String name) {
        return repository.findByNombreContaining(name);
    }

    // Busca similares pero no el mismo item
    public List<Producto> findSimilar(Producto producto) {
        Categoria categoria = producto.getCateogria();
        List<Producto> similares = repository.findByCateogriaId(categoria.getId());

        similares.removeIf(p -> p.getCateogria().getId() == categoria.getId());

        return similares;
    }

}
