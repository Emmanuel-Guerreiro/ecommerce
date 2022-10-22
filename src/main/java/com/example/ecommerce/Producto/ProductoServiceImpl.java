package com.example.ecommerce.Producto;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Base.BaseServiceImpl;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Long, ProductoRepository>
        implements ProductoService {

    @Override
    public Page<Producto> findAll(Pageable p) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
