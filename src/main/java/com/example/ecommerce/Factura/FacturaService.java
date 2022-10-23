package com.example.ecommerce.Factura;

import com.example.ecommerce.Base.BaseService;

public interface FacturaService extends BaseService<Factura, Long> {

    public Factura save(Long carritoId) throws Exception;
}
