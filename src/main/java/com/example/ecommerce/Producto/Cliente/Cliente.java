package com.example.ecommerce.Producto.Cliente;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;
}
