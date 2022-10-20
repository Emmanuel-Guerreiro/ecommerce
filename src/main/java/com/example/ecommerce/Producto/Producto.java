package com.example.ecommerce.Producto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "productos")
@Setter
@Getter
@Data
@NoArgsConstructor
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
