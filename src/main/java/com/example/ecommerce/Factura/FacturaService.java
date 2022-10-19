/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerce.Factura;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FacturaService{
    @Autowired
    private FacturaRepository fact_repository;

 
    public List<Factura> findAll() throws Exception {
        try{
            List<Factura> facturas = fact_repository.findAll();
            return facturas;
        }catch(Exception e){
            return null;
        }
    }

    
    public Factura findById(Long id) {
        Optional<Factura> fact = fact_repository.findById(id);
       return fact.get();
    }

    
    public Factura save(Factura entity) throws Exception {
        return fact_repository.save(entity);
    }


    @Transactional
    public Factura update(Long id, Factura entity) throws Exception {
        fact_repository.deleteById(id);
        fact_repository.save(entity);
       return fact_repository.findById(id).get();
    }

   
    @Transactional
    public boolean delete(Long id) throws Exception {
        if(fact_repository.existsById(id)){
            fact_repository.deleteById(id);
            return true;
        }
        return false;
    }
}
