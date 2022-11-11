package com.example.ecommerce.Producto;

import java.util.List;

import com.example.ecommerce.Base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoRepository extends BaseRepository<Producto, Long> {
    @Override
    List<Producto> findAll();

    List<Producto> findByCateogriaId(Long id);
    
    
    @Query( value = "select * from producto p where p.nombre like %:filter% " ,
    nativeQuery = true)
    List<Producto> findByFilter(@Param("filter") String filter);
}
