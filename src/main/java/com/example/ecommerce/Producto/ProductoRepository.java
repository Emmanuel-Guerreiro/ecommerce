package com.example.ecommerce.Producto;

import java.util.List;

import com.example.ecommerce.Base.BaseRepository;

public interface ProductoRepository extends BaseRepository<Producto, Long> {
    @Override
    List<Producto> findAll();

    List<Producto> findByCateogriaId(Long id);

    List<Producto> findByNombreContaining(String name);

    List<Producto> findByNombreOrCateogriaId(String name, Long id);
}
