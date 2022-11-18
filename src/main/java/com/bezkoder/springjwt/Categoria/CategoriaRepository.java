package com.bezkoder.springjwt.Categoria;

import java.util.List;
import java.util.Optional;

import com.bezkoder.springjwt.Base.BaseRepository;

public interface CategoriaRepository extends BaseRepository<Categoria, Long> {

    Optional<Categoria> findByNombre(String nombre);

    @Override
    List<Categoria> findAll();

}
