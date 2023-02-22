package com.example.demoorm.service;

import java.util.List;

public interface Crud<E> {
    List<E> findAll();
    void create(E e);
    void update(E e);
    void delete(int id);
    E findById(int id);
}
