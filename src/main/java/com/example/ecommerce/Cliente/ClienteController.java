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

}
