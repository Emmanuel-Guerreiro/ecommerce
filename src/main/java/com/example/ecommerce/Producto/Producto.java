package com.example.ecommerce.Producto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.ecommerce.Base.BaseEntity;
import com.example.ecommerce.Categoria.Categoria;

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

    @Column(name = "stock")
    private int stock;

    @Column(name = "imagen")
    private String imagen;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_categoria")
    private Categoria cateogria;
}
