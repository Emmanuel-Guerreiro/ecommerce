package com.example.ecommerce.Producto.DTO;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class DTOProductoUI {
    private float precio;
    private String nombre;
    private List<String> categorias;
}
