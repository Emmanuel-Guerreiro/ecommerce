/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerce.Factura;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Base.BaseServiceImpl;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long, FacturaRepository> implements FacturaService {

    @Override
    public Page<Factura> findAll(Pageable p) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}