package com.example.ecommerce.Cliente;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Base.BaseServiceImpl;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long, ClienteRepository> implements ClienteService {

    @Override
    public Page<Cliente> findAll(Pageable p) throws Exception {
        // This method is simply defined because of BaseServiceImpl
        return null;
    }
}
