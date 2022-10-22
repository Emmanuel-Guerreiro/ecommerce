/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerce.Carrito;

import com.example.ecommerce.Base.Base;
import com.example.ecommerce.Cliente.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "carrito")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Carrito extends Base {
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente",nullable = false)
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCarrito> detalles = new ArrayList<DetalleCarrito>();
}
