package com.example.ecommerce.Carrito;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Base.BaseServiceImpl;

@Service
public class CarritoServiceImpl extends BaseServiceImpl<Carrito, Long, CarritoRepository> {

    @Override
    public Page<Carrito> findAll(Pageable p) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
