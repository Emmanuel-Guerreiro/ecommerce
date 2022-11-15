/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerce.Factura;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Base.BaseControllerImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/facturas")
public class FacturaControllerImpl extends BaseControllerImpl<Factura, Long, FacturaServiceImpl> implements
        FacturaController {

    public FacturaControllerImpl(FacturaServiceImpl service) {
        super(service);
    }

    // dentro de carrito
    @PostMapping("/pagar-carrito/{carritoId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Factura save(@PathVariable Long carritoId) throws Exception {

        return this.service.saveFromFactura(carritoId);
    }

}
