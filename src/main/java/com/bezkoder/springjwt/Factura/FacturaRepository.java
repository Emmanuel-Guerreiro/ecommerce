package com.bezkoder.springjwt.Factura;

import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.Base.BaseRepository;
import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura, Long> {

    List<Factura> findAllByUsuarioId(Long id);
}