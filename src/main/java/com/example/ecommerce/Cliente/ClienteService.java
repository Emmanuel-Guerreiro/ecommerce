package com.example.ecommerce.Cliente;

import com.example.ecommerce.Base.BaseService;
import com.example.ecommerce.Producto.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements BaseService<Cliente> {
    private ClienteRepository repository;
    private ModelMapper mapper;

    @Autowired
    ClienteService(ClienteRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Cliente> findAll() throws Exception {
        return null;
    }

    @Override
    public Cliente findById(Long id) throws Exception {
        return null;
    }

    @Override
    public Cliente save(Cliente entity) throws Exception {
        return null;
    }

    @Override
    public Cliente update(Long id, Cliente entity) throws Exception {
        return null;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        return false;
    }
}
