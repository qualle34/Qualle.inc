package com.inc.qualle.service.dao;

import java.util.List;

public interface BaseService<T, ID> {

    List<T> getAll();

    T getById(ID id);

    T save(T t);

    void delete(ID id);
}
