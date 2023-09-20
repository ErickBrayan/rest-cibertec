package com.example.demorestcibertec.controllers;

import com.example.demorestcibertec.dtos.Message;
import com.example.demorestcibertec.entities.BaseEntity;
import com.example.demorestcibertec.services.BaseServiceImpl;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseControllerImpl<E extends BaseEntity, S extends BaseServiceImpl<E,Long> > implements BaseController<E, Long> {


    protected final S service;

    public BaseControllerImpl(S service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() throws Exception {
        List<E> personaEntityList = service.findAll();
        try {

            if (personaEntityList.isEmpty()){
                return new ResponseEntity<>(personaEntityList,HttpStatus.OK);
            }
            return new ResponseEntity<>(personaEntityList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) throws Exception {


        try {

            E entity = service.findById(id);
            if (entity != null){
                return new ResponseEntity<>(entity, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(new Message("Persona no existe"),HttpStatus.NOT_FOUND);
            }
        }catch (RuntimeException e){
            return new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity) throws Exception {

        try {
            return new ResponseEntity<>(service.save(entity), HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity) throws Exception {

        try {
            return new ResponseEntity<>(service.update(id,entity), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {

        try {
            boolean res = service.delete(id);
            return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
