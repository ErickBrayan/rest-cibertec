package com.example.demorestcibertec.services;

import java.util.List;

public interface BaseService<E> {

     List<E> findAll() throws Exception;
     public E findById(Long id) throws Exception;

     E save(E e) throws Exception;
     E update(Long id, E e) throws Exception;
     boolean delete(Long id) throws Exception;


}
