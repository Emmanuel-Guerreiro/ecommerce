package com.example.ecommerce.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Base.BaseControllerImpl;
import com.example.ecommerce.Producto.DTO.DTOCreateProducto;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/producto")
public class ProductoControllerImpl
        extends BaseControllerImpl<Producto, Long, ProductoServiceImpl>
        implements ProductoController {

    @Autowired
    public ProductoService productoServ;

    @Autowired
    public ProductoControllerImpl(ProductoServiceImpl service) {
        super(service);
    }

    @PostMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Producto save(@RequestBody DTOCreateProducto entity) throws Exception {
        System.out.println(entity.toString());
        System.out.println("______________________---------------");
        return this.service.save(entity);
    }

    @PostMapping("/prueba")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public int probando(@ModelAttribute DTOCreateProducto dto) {
        System.out.println("*****************************");
        System.out.println(dto.getNombre());
        System.out.println("*****************************");
        return 1;
    }

}
