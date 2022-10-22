package com.example.ecommerce.Cliente;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.Base.BaseControllerImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/cliente")
public class ClienteControllerImpl extends BaseControllerImpl<Cliente, Long, ClienteServiceImpl> implements
        ClienteController {

    public ClienteControllerImpl(ClienteServiceImpl service) {
        super(service);

    }

}
