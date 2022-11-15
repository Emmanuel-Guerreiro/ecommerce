package com.example.ecommerce.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Base.BaseControllerImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/categorias")
public class CategoriaControllerImpl
        extends BaseControllerImpl<Categoria, Long, CategoriaServiceImpl>
        implements CategoriaController {

    @Autowired
    public CategoriaControllerImpl(CategoriaServiceImpl service) {
        super(service);
    }

}
