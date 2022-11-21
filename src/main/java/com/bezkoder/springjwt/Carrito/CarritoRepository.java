
package com.bezkoder.springjwt.Carrito;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.Base.BaseRepository;

@Repository
public interface CarritoRepository extends BaseRepository<Carrito, Long> {

    Optional<Carrito> findByUsuarioId(Long id);
}
