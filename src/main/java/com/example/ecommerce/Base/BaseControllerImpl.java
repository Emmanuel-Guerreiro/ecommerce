package com.example.ecommerce.Base;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

public abstract class BaseControllerImpl<E extends BaseEntity, ID extends Serializable, S extends BaseService<E, ID>>
        implements BaseController<E, ID> {

    protected S service;

    @Autowired
    BaseControllerImpl(S service) {
        this.service = service;
    }

    @Override
    public E delete(ID id) throws Exception {
        return this.service.delete(id);
    }

    @Override
    public Page<E> getAll(Pageable pageable) throws Exception {
        // TODO Auto-generated method stub
        return this.service.findAll(pageable);
    }

    @Override
    public List<E> getAll() throws Exception {
        // TODO Auto-generated method stub
        return this.service.findAll();
    }

    @Override
    public E getOne(ID idE) throws Exception {
        // TODO Auto-generated method stub
        return this.service.findById(idE);
    }

    @Override
    public E save(E entity) throws Exception {
        // TODO Auto-generated method stub
        return this.service.save(entity);
    }

    @Override
    public E update(ID id, E entity) throws Exception {
        // TODO Auto-generated method stub
        return this.service.update(id, entity);
    }
}
