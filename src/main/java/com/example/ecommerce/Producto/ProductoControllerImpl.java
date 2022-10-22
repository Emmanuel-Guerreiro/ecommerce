package com.example.ecommerce.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Base.BaseControllerImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/producto")
public class ProductoControllerImpl extends BaseControllerImpl<Producto, Long, ProductoServiceImpl>
        implements ProductoController {

    @Autowired
    public ProductoControllerImpl(ProductoServiceImpl service) {
        super(service);
    }

}
