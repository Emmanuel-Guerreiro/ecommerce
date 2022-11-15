package com.example.ecommerce.Base;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseServiceImpl<E extends BaseEntity, ID extends Serializable, R extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {

    protected R repository;

    @Autowired
    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E delete(ID id) throws Exception {
        Optional<E> toRemove = this.repository.findById(id);
        if (!toRemove.isPresent()) {
            throw new Exception();
        }
        this.repository.deleteById(id);

        return toRemove.get();
    }

    @Override
    public E findById(ID id) throws Exception {

        E a = this.repository.findById(id).get();
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(a.getId());
        return a;
    }

    @Override
    public Page<E> findAll(Pageable pageable) throws Exception {
        return this.repository.findAll(pageable);
    }

    @Override
    public List<E> findAll() throws Exception {
        return this.repository.findAll();
    }

    @Override
    public E save(E entity) throws Exception {
        return this.repository.save(entity);
    }

    @Override
    public E update(ID id, E entity) throws Exception {
        Optional<E> opt = this.repository.findById(id);
        if (!opt.isPresent()) {
            throw new Exception();
        }
        E oldValue = opt.get();
        entity.setId(oldValue.getId());

        E saved = this.repository.save(entity);

        return saved;
    }
}
