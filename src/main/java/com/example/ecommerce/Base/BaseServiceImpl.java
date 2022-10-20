package com.example.ecommerce.Base;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl<E extends BaseEntity, ID extends Serializable> implements BaseService<E, ID> {
    protected BaseRepository<E, ID> baseRepository;

    @Autowired
    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public E delete(ID id) throws Exception {
        Optional<E> toRemove = this.baseRepository.findById(id);
        if (!toRemove.isPresent()) {
            throw new Exception();
        }
        this.baseRepository.deleteById(id);

        return toRemove.get();
    }

    @Override
    public List<E> findAll() throws Exception {
        return this.baseRepository.findAll();
    }

    @Override
    public E findById(ID id) throws Exception {
        return this.baseRepository.findById(id).get();
    }

    @Override
    public E save(E entity) throws Exception {
        return this.baseRepository.save(entity);
    }

    @Override
    public E update(ID id, E entity) throws Exception {
        Optional<E> opt = this.baseRepository.findById(id);
        if (!opt.isPresent()) {
            throw new Exception();
        }
        E oldValue = opt.get();
        entity.setId(oldValue.getId());

        E saved = this.baseRepository.save(entity);

        return saved;
    }
}
