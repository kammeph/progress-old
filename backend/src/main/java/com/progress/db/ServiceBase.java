package com.progress.db;

import java.util.List;

public interface ServiceBase<T, ID> {
    List<T> getAll();
    T get(ID id);
    T create(T entity);
    Boolean update(ID id, T entity) throws IllegalArgumentException, IllegalAccessException;
    Boolean delete(ID id);
    Class<T> getPersistenceClass();
}
