package com.bezkoder.springjwt.Producto.DTO;

import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DTOCreateProducto {
    private float precio;
    private String nombre;
    private Long categoria;
    private int stock;
    private MultipartFile imagen;

    @Override
    public String toString() {
        return String.format("%s %s %d", nombre, categoria, stock);
    }

}
