/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.ecommerce.Carrito;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarritoService {
       @Autowired
    private CarritoRepository carrito_repository;

 
    public List<Carrito> findAll() throws Exception {
        try{
            List<Carrito> facturas = carrito_repository.findAll();
            return facturas;
        }catch(Exception e){
            return null;
        }
    }

    
    public Carrito findById(Long id) {
        Optional<Carrito> fact = carrito_repository.findById(id);
       return fact.get();
    }

    
    public Carrito save(Carrito entity) throws Exception {
        return carrito_repository.save(entity);
    }


    @Transactional
    public Carrito update(Long id, Carrito entity) throws Exception {
        carrito_repository.deleteById(id);
        carrito_repository.save(entity);
       return carrito_repository.findById(id).get();
    }

   
    @Transactional
    public boolean delete(Long id) throws Exception {
        if(carrito_repository.existsById(id)){
            carrito_repository.deleteById(id);
            return true;
        }
        return false;
    }
}
