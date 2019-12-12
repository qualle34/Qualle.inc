package com.qualle.api.dao;

public interface IGenericDao<T, ID> {

    T getById(ID id);

    void add(T t);

    void update(T t);

    void delete(T t);
}
