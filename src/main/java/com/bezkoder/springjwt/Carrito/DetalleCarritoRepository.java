/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bezkoder.springjwt.Carrito;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DetalleCarritoRepository extends JpaRepository<DetalleCarrito,Long> {
    
    @Modifying
    @Transactional
    @Query(value = "delete from carrito_detalles where detalles_id = :id", nativeQuery = true)
    public void deleteFromJoinTable(@Param("id")Long id);
}
