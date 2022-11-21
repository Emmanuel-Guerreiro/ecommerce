package com.bezkoder.springjwt.Factura;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.Base.BaseServiceImpl;
import com.bezkoder.springjwt.Carrito.Carrito;
import com.bezkoder.springjwt.Carrito.CarritoServiceImpl;
import com.bezkoder.springjwt.Carrito.DetalleCarrito;

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

    public Factura saveFromFactura(Long userId) throws Exception {
        Carrito c = this.carritoService.findByUsuarioId(userId);
        Factura f = carritoFromFactura(c);

        return repository.save(f);
    };

    private Factura carritoFromFactura(Carrito c) {
        Factura nFactura = new Factura();
        nFactura.setFecha(new Date());
        nFactura.setUsuario(c.getUsuario());

        for (DetalleCarrito detalleC : c.getDetalles()) {

            DetalleFactura detalleF = DetalleFactura
                    .builder()
                    .producto(detalleC.getProducto())
                    .cantidad(detalleC.getCantidad())
                    .precio(detalleC.getProducto().getPrecio())
                    .build();

            nFactura.addDetalle(detalleF);
        }

        double precioTotal = 0;
        for (DetalleFactura df : nFactura.getDetalles()) {
            precioTotal += df.getPrecio()*df.getCantidad();
        }

        nFactura.setMontoTotal(precioTotal);

        return nFactura;
    }

}
