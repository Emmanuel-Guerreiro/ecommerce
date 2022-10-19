package com.example.ecommerce.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/cliente")
public class ClienteController {

    private final ClienteService service;

    @Autowired
    ClienteController(ClienteService service){ this.service = service;}

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Cliente getOne(@PathVariable Long id) { return this.service.findById(id);}

    //@PostMapping()
    //@ResponseBody
    //@ResponseStatus(HttpStatus.CREATED)
    //public Cliente create(@RequestBody DTOCreateCliente c){
     //   System.out.println();
    //}
}
