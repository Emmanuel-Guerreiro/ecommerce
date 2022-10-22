package com.example.ecommerce.Producto;

import java.util.List;

import com.example.ecommerce.Base.BaseRepository;

public interface ProductoRepository extends BaseRepository<Producto, Long> {
    @Override
    List<Producto> findAll();

}
