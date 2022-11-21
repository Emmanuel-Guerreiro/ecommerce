package com.bezkoder.springjwt.Factura;

import com.bezkoder.springjwt.Base.BaseService;

public interface FacturaService extends BaseService<Factura, Long> {

    public Factura saveFromFactura(Long carritoId) throws Exception;
}
