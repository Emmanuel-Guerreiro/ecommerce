package com.example.ecommerce.Base;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class BaseControllerImpl<E extends BaseEntity, ID extends Serializable, S extends BaseService<E, ID>>
        implements BaseController<E, ID> {

    protected S service;

    @Autowired
    public BaseControllerImpl(S service) {
        this.service = service;
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public E delete(@PathVariable ID id) throws Exception {
        return this.service.delete(id);
    }

    @Override
    @GetMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Page<E> getAll(Pageable pageable) throws Exception {
        return this.service.findAll(pageable);
    }

    @Override
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public E getOne(@PathVariable ID id) throws Exception {

        return this.service.findById(id);

    }

    @Override
    @PostMapping("/save")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public E save(@RequestBody E entity) throws Exception {
        return this.service.save(entity);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public E update(@PathVariable ID id, @RequestBody E entity) throws Exception {
        System.out.println(id);
        return this.service.update(id, entity);
    }
}
