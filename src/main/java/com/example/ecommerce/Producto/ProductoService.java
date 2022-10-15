package com.example.ecommerce.Producto;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Producto.DTO.DTOCreateProducto;

@Service
public class ProductoService {
    private ProductoRepository repository;
    private ModelMapper mapper;

    @Autowired
    ProductoService(ProductoRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // TODO: Add query params
    public List<Producto> findAll() {
        return this.repository.findAll();
    }

    public Producto create(DTOCreateProducto producto) {
        Producto p = mapper.map(producto, Producto.class);
        return this.repository.save(p);
    }

    public Producto findById(Long id) {
        return this.repository.findById(id).get();
    }
}
