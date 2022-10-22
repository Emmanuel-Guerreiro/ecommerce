/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerce.Carrito;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Base.BaseControllerImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/carrito")
public class CarritoControllerImpl extends BaseControllerImpl<Carrito, Long, CarritoServiceImpl> implements
        CarritoController {

    public CarritoControllerImpl(CarritoServiceImpl service) {
        super(service);
        // TODO Auto-generated constructor stub
    }

}
