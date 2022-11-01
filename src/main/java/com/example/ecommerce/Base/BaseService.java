package com.example.ecommerce.Base;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BaseService<E, ID> {

    public Page<E> findAll(Pageable p) throws Exception;

    public List<E> findAll() throws Exception;

    public E findById(ID id) throws Exception;

    public E save(E entity) throws Exception;

    public E update(ID id, E entity) throws Exception;

    public E delete(ID id) throws Exception;
}
