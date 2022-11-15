package com.example.ecommerce.Factura;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Base.BaseServiceImpl;
import com.example.ecommerce.Carrito.Carrito;
import com.example.ecommerce.Carrito.CarritoServiceImpl;
import com.example.ecommerce.Carrito.DetalleCarrito;

@Service
public class FacturaServiceImpl
        extends BaseServiceImpl<Factura, Long, FacturaRepository> {

    CarritoServiceImpl carritoService;

    @Autowired
    public FacturaServiceImpl(FacturaRepository repository,
            CarritoServiceImpl carritoService) {
        super(repository);
        this.carritoService = carritoService;
    }

    public Factura saveFromFactura(Long carritoId) throws Exception {
        Carrito c = this.carritoService.findById(carritoId);
        Factura f = carritoFromFactura(c);

        return repository.save(f);
    };

    private Factura carritoFromFactura(Carrito c) {
        Factura nFactura = new Factura();
        nFactura.setFecha(new Date());
        nFactura.setCliente(c.getCliente());

        for (DetalleCarrito detalleC : c.getDetalles()) {

            DetalleFactura detalleF = DetalleFactura
                    .builder()
                    .producto(detalleC.getProducto())
                    .cantidad(detalleC.getCantidad())
                    .precio(detalleC.getProducto().getPrecio())
                    .build();

            nFactura.addDetalle(detalleF);
        }

        float precioTotal = 0;
        for (DetalleFactura df : nFactura.getDetalles()) {
            precioTotal += df.getPrecio();
        }

        nFactura.setMontoTotal(precioTotal);

        return nFactura;
    }

}
