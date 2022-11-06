package com.example.ecommerce.Frontend.DTO;

import java.util.List;

import com.example.ecommerce.Producto.Producto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTOProductoUI {
    private String nombre;
    private float precio;
    private int maxCant;
    private String imagen;
    private Long categoria;
    private List<Producto> similares;
}
