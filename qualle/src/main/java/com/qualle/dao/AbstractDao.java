package com.qualle.dao;

import com.qualle.api.dao.IGenericDao;
import com.qualle.entity.User;

import java.util.Date;

public class AbstractDao<T, ID> implements IGenericDao<T, ID> {

    @Override
    public T getById(ID id) {
        return null;
    }

    @Override
    public void add(T t) {

    }

    @Override
    public void update(T t) {

    }

    @Override
    public void delete(T t) {

    }
}
