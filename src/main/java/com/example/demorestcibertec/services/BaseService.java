package com.example.demorestcibertec.services;

import com.example.demorestcibertec.entities.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntity,ID extends Serializable> {

     List<E> findAll() throws Exception;
     public E findById(ID id) throws Exception;

     E save(E e) throws Exception;
     E update(ID id, E e) throws Exception;
     boolean delete(ID id) throws Exception;


}
