package com.inc.qualle.service.dao.impl;

import com.inc.qualle.service.dao.BaseService;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractService<T, ID> implements BaseService<T, ID> {

    @Override
    public List<T> getAll() {
        List<T> result = new ArrayList<>();
        getRepository().findAll().forEach(result::add);
        return result;
    }

    @Override
    public T getById(ID id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public T save(T t) {
        return getRepository().save(t);
    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    protected abstract CrudRepository<T, ID> getRepository();
}
