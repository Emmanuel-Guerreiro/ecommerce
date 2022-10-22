/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerce.Cliente;
import java.io.Serializable;
import javax.persistence.*;

import com.example.ecommerce.Base.Base;
import com.example.ecommerce.Carrito.Carrito;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "Cliente")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class Cliente extends Base {

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "email")
    private String email;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "contraseña")
    private String contrasena;
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "fk_carrito")
    //private Carrito carrito;

}
