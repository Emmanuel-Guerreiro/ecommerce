package com.example.ecommerce.Producto.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DTOCreateProducto {
    private float precio;
    private String nombre;
    private String categoria;
}
