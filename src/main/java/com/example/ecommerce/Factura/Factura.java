
package com.example.ecommerce.Factura;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.ecommerce.Base.BaseEntity;
import com.example.ecommerce.Cliente.Cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Factura extends BaseEntity {

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "montoTotal")
    private double montoTotal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente", nullable = false)
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

    public void addDetalle(DetalleFactura detalle) {
        if (this.detalles == null) {
            this.detalles = new ArrayList<DetalleFactura>();
        }

        this.detalles.add(detalle);
    }
}