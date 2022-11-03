package com.example.ecommerce.Frontend.DTO;

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
}
