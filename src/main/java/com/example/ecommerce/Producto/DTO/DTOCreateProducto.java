package com.example.ecommerce.Producto.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DTOCreateProducto {
    private float precio;
    private String nombre;
    private String categoria;
    private int stock;

    @Override
    public String toString() {
        return String.format("%s %s", nombre, categoria);
    }

}
