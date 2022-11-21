/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bezkoder.springjwt.Factura;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.springjwt.Base.BaseControllerImpl;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/facturas")
public class FacturaControllerImpl extends BaseControllerImpl<Factura, Long, FacturaServiceImpl> implements
        FacturaController {

    public FacturaControllerImpl(FacturaServiceImpl service) {
        super(service);
    }

    // dentro de carrito
    @PostMapping("/pagar-carrito/{userId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@PathVariable Long userId) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.service.saveFromFactura(userId));
        } catch (Exception e) {
            Gson json = new Gson();          
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json.toJson(e.getMessage()));
        }

    }
}
