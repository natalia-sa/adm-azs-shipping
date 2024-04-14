package com.azship.azship.services.basic;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BasicService<T, ID> {

    public default List<T> findAll() {
        return getRepository().findAll();
    }

    public default Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    public default void deleteById(ID id) {
        getRepository().deleteById(id);
    }

    @Transactional
    public default void delete(T entity) {
        getRepository().delete(entity);
    }

    @Transactional
    public default void deleteAll() {
        getRepository().deleteAll();
    }

    @Transactional
    public default T save(T entity) {
        return getRepository().save(entity);
    }

    public JpaRepository<T, ID> getRepository();
}
