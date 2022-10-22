package com.example.ecommerce.Producto;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    private ProductoRepository repository;

    @Autowired
    ProductoService(ProductoRepository repository, ModelMapper mapper) {
        this.repository = repository;
    }

    // TODO: Add query params
    public List<Producto> findAll() {
        return this.repository.findAll();
    }

    public Producto create(Producto producto) {
        return this.repository.save(producto);
    }

    public Producto findById(Long id) {
        return this.repository.findById(id).get();
    }

    public Producto remove(Long id) {
        Optional<Producto> toRemove = repository.findById(id);
        // TODO: Handle not found exception
        // if (!toRemove.isPresent()) {
        // throw new Exception();
        // }
        repository.deleteById(id);
        return toRemove.get();
    }

    public Producto update(Long id, Producto newValues) {
        // Todo: Handle not found exception
        Producto oldValue = repository.findById(id).get();
        newValues.setId(oldValue.getId());
        return repository.save(newValues);
    }
}
