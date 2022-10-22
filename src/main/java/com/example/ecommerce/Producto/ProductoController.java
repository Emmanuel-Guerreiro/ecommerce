package com.example.ecommerce.Producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Base.BaseControllerImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/producto")
public class ProductoController extends BaseControllerImpl<Producto, Long, ProductoServiceImpl> {

    @Autowired
    public ProductoController(ProductoServiceImpl service) {
        super(service);
    }

    @GetMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> getAll()
            throws Exception {

        return this.service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Producto getOne(@PathVariable Long id)
            throws Exception {

        return this.service.findById(id);
    }

    @PostMapping()
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Producto create(@RequestBody Producto p)
            throws Exception {

        return this.service.save(p);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Producto remove(@PathVariable Long id)
            throws Exception {

        return this.service.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Producto update(@PathVariable Long id, @RequestBody Producto p)
            throws Exception {

        return this.service.update(id, p);
    }
}
