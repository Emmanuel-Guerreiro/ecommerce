package com.example.ecommerce.Producto.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CategoriaService {

    private CategoriaRepository repository;

    @Autowired
    CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria findOrCreate(String nombre) {

        return this.repository.findByNombre(nombre)
                .orElseGet(() -> this.create(nombre));
    }

    public Categoria create(String nombre) {
        Categoria nCategoria = Categoria
                .builder()
                .nombre(nombre)
                .build();
        return this.repository.save(nCategoria);
    }

}
