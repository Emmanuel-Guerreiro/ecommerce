package com.example.ecommerce.Producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Producto.DTO.DTOCreateProducto;

//TODO: Handle errors

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/producto")
public class ProductoController {

    private final ProductoService service;

    @Autowired
    ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> getAll() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Producto getOne(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PostMapping()
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Producto create(@RequestBody DTOCreateProducto p) {
        System.out.println(p.toString());
        return this.service.create(p);
    }

}
