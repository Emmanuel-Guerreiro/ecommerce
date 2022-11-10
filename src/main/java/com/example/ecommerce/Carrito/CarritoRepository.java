
package com.example.ecommerce.Carrito;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.ecommerce.Base.BaseRepository;

@Repository
public interface CarritoRepository extends BaseRepository<Carrito, Long> {

    Optional<Carrito> findByClienteId(Long id);
}
