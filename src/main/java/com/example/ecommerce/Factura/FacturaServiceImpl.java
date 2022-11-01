package com.example.ecommerce.Factura;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Base.BaseServiceImpl;
import com.example.ecommerce.Carrito.Carrito;
import com.example.ecommerce.Carrito.CarritoServiceImpl;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long, FacturaRepository> implements FacturaService {

    CarritoServiceImpl carritoService;

    @Autowired
    public FacturaServiceImpl(FacturaRepository repository,
            CarritoServiceImpl carritoService) {
        super(repository);
        this.carritoService = carritoService;
    }

    @Override
    public Factura save(Long carritoId) throws Exception {
        Carrito c = this.carritoService.findById(carritoId);
        Factura f = carritoFromFactura(c);

        return this.repository.save(f);
    };

    private Factura carritoFromFactura(Carrito c) {
        Factura nFactura = new Factura();
        nFactura.setFecha(new Date());

        c.getDetalles().forEach(detalleC -> {

            DetalleFactura detalleF = DetalleFactura
                    .builder()
                    .producto(detalleC.getProducto())
                    .cantidad(detalleC.getCantidad())
                    .precio(detalleC.getProducto().getPrecio())
                    .build();

            nFactura.addDetalle(detalleF);
        });

        return nFactura;
    }

}
