package com.example.ecommerce.Base;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface BaseController<E extends BaseEntity, ID extends Serializable> {

    Page<E> getAll(Pageable pageableE) throws Exception;

    E getOne(@PathVariable ID idE) throws Exception;

    E save(@RequestBody E entity) throws Exception;

    E update(@PathVariable ID id, @RequestBody E entity) throws Exception;

    E delete(@PathVariable ID id) throws Exception;
}
