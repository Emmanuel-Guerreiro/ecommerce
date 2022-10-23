package com.example.ecommerce.Producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Base.BaseServiceImpl;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Long, ProductoRepository>
        implements ProductoService {

    @Autowired
    public ProductoServiceImpl(ProductoRepository repository) {
        super(repository);

    }

}
