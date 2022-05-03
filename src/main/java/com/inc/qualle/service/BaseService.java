package com.inc.qualle.service;

import java.util.Collection;

public interface BaseService<T, ID> {

    Collection<T> getAll();

    T getById(ID id);

    T save(T t);

    void delete(ID id);
}
