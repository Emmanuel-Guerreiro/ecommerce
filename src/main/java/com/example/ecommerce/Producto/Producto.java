package com.example.ecommerce.Producto;

import lombok.*;

import java.util.Set;

import javax.persistence.*;

import com.example.ecommerce.Producto.Categoria.Categoria;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "producto")
@Setter
@Getter
@Data
@NoArgsConstructor
@Audited
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "precio")
    private float precio;

    @Column(name = "nombre")
    private String nombre;

    // @ManyToMany
    // @JoinTable(name = "producto_categoria", joinColumns = @JoinColumn(name =
    // "producto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    // private Set<Categoria> categorias;
}
