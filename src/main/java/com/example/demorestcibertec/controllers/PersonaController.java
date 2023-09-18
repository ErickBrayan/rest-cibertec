package com.example.demorestcibertec.controllers;

import com.example.demorestcibertec.dtos.Message;
import com.example.demorestcibertec.entities.PersonaEntity;
import com.example.demorestcibertec.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/personas")
public class PersonaController {

    private final PersonaService personaService;

    @GetMapping("")
    public ResponseEntity<?> findAll() throws Exception {
        List<PersonaEntity> personaEntityList = personaService.findAll();
        try {

            if (personaEntityList.isEmpty()){
                return new ResponseEntity<>(personaEntityList, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(personaEntityList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) throws Exception {
        PersonaEntity persona = personaService.findById(id);

        try {
            if (persona != null){
                return new ResponseEntity<>(persona, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(new Message("Persona no existe"),HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody PersonaEntity personaEntity) throws Exception {

        try {
            PersonaEntity persona = personaService.save(personaEntity);
            return new ResponseEntity<>(persona, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PersonaEntity personaEntity) throws Exception {

        try {
            PersonaEntity persona = personaService.update(id,personaEntity);
            return new ResponseEntity<>(persona, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {

        try {
            boolean res = personaService.delete(id);
            return new ResponseEntity<>(res, HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>("error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
