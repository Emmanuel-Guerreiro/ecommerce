package com.bezkoder.springjwt.Producto;

import java.util.List;

import com.bezkoder.springjwt.Base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoRepository extends BaseRepository<Producto, Long> {

    @Override
    List<Producto> findAll();

    @Query(value = "select * from producto p where p.stock>0 and p.fecha_hora_baja is null and fk_categoria = :id", nativeQuery = true)
    List<Producto> findByCateogriaId(@Param("id") Long id);

    @Query(value = "select * from producto p where p.stock>0 and p.fecha_hora_baja is null and nombre like %:name%", nativeQuery = true)
    List<Producto> findByNombreContaining(@Param("name")String name);

    List<Producto> findByNombreOrCateogriaId(String name, Long id);

    @Query(value = "select * from producto p where p.stock>0 and p.fecha_hora_baja is null", nativeQuery = true)
    List<Producto> findAllDisponibles();
}
