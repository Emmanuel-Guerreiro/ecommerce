package com.example.ecommerce.Carrito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Base.BaseControllerImpl;
import com.example.ecommerce.Carrito.DTO.DTOAddItem;
import com.example.ecommerce.Carrito.DTO.DTOCreateCarrito;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/carrito")
public class CarritoControllerImpl extends BaseControllerImpl<Carrito, Long, CarritoServiceImpl> implements
        CarritoController {

    @Autowired
    public CarritoControllerImpl(CarritoServiceImpl service) {
        super(service);

    }

    @PostMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Carrito save(@RequestBody DTOCreateCarrito dto) throws Exception {
        return this.service.save(dto);
    }

    @PostMapping("/{id}/item")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleCarrito addItem(
            @PathVariable long id,
            @RequestBody DTOAddItem addItem)
            throws Exception {

        return this.service.addItem(id, addItem);
    }

}
