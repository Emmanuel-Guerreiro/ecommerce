package com.example.ecommerce.Producto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.ecommerce.Base.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "producto")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Producto extends BaseEntity {

    @Column(name = "precio")
    private float precio;

    @Column(name = "nombre")
    private String nombre;

    // @ManyToMany
    // @JoinTable(name = "producto_categoria", joinColumns = @JoinColumn(name =
    // "producto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    // private Set<Categoria> categorias;
}
