package com.example.ecommerce.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/cliente")
public class ClienteController {

    private final ClienteService service;

    @Autowired
    ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Cliente getOne(@PathVariable Long id) {
        return this.service.findById(id);
    }

    // @PostMapping()
    // @ResponseBody
    // @ResponseStatus(HttpStatus.CREATED)
    // public Cliente create(@RequestBody DTOCreateCliente c){
    // System.out.println();
    // }
}
