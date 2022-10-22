package com.example.ecommerce.Base;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

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

    // Todo: Acomodar esto cuadno este implementado correctamente la paginacio
    @Override
    @GetMapping("/paged")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Page<E> getAll(Pageable pageable) throws Exception {

        return this.service.findAll(pageable);
    }

    @Override
    @GetMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<E> getAll() throws Exception {

        return this.service.findAll();
    }

    @Override
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public E getOne(@PathVariable ID id) throws Exception {

        return this.service.findById(id);

    }

    @Override
    @PostMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public E save(E entity) throws Exception {

        return this.service.save(entity);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public E update(@PathVariable ID id, E entity) throws Exception {
        System.out.println(id);
        return this.service.update(id, entity);
    }
}
