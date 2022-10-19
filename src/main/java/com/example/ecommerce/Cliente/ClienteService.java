package com.example.ecommerce.Cliente;

import com.example.ecommerce.Producto.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository repository;
    private ModelMapper mapper;

    @Autowired
    ClienteService(ClienteRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //public Cliente create(DTOCreateCliente cliente){
      //  Cliente c = mapper.map(cliente, Cliente.class);
        //return this.repository.save(c);
    //}

    public Cliente findById(Long id) {return this.repository.findById(id).get();}
}
