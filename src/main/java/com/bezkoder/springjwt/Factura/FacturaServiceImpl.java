package com.bezkoder.springjwt.Factura;

import Exceptions.DadoBajaException;
import Exceptions.SinStockException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.Base.BaseServiceImpl;
import com.bezkoder.springjwt.Carrito.Carrito;
import com.bezkoder.springjwt.Carrito.CarritoServiceImpl;
import com.bezkoder.springjwt.Carrito.DetalleCarrito;
import com.bezkoder.springjwt.Producto.Producto;
import com.bezkoder.springjwt.Producto.ProductoRepository;

@Service
public class FacturaServiceImpl
        extends BaseServiceImpl<Factura, Long, FacturaRepository> {

    CarritoServiceImpl carritoService;
    @Autowired
    ProductoRepository product_repo;

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

    private Factura carritoFromFactura(Carrito c) throws SinStockException, DadoBajaException, Exception {
        if(c.getDetalles().size()== 0){
         throw new Exception("Error: carrito vacio");
        }
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
            Producto prod = df.getProducto();
            if(disponibilidadProducto(df)){
            prod.setStock(prod.getStock()-df.getCantidad());
            this.product_repo.save(prod);           
        }
        }

        nFactura.setMontoTotal(precioTotal);

        return nFactura;
    }
    
    
    boolean disponibilidadProducto(DetalleFactura df) throws SinStockException, DadoBajaException{
        boolean disponible=true;
       Producto producto = df.getProducto();
            if(producto.getStock() < df.getCantidad()){
                disponible = false;
                throw (new SinStockException("No hay suficiente stock del producto: "+producto.getNombre()));
            }
            if(producto.getFechaHoraBaja() != null){
                disponible = false;
                throw (new DadoBajaException("El producto: "+producto.getNombre()+" ya no se encuentra disponible"));
            }
        
        return disponible;
    }

}
