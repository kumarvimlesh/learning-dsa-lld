package com.java.learning.lld.foodDeliverySystem.repository;

import java.util.List;

public interface CrudRepository<T, I> {
    T save(T t);
    T findById(I i);
    List<T> findAll();
    void deleteById(I i);
}
