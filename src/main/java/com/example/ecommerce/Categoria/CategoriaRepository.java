package com.example.ecommerce.Categoria;

import java.util.List;
import java.util.Optional;

import com.example.ecommerce.Base.BaseRepository;

public interface CategoriaRepository extends BaseRepository<Categoria, Long> {

    Optional<Categoria> findByNombre(String nombre);

    @Override
    List<Categoria> findAll();

}
