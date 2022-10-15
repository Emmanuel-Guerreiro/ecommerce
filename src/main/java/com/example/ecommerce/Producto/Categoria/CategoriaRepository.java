package com.example.ecommerce.Producto.Categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    Optional<Categoria> findByNombre(String nombre);

    @Override
    List<Categoria> findAll();

}
