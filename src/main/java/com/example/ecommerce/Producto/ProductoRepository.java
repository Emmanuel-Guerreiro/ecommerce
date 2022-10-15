package com.example.ecommerce.Producto;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long> {
    @Override
    List<Producto> findAll();

}
