package com.example.demorestcibertec.controllers;


import com.example.demorestcibertec.entities.PersonaEntity;
import com.example.demorestcibertec.services.PersonaServiceImpl;

import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/personas")
public class PersonaController extends BaseControllerImpl<PersonaEntity,PersonaServiceImpl>{
    public PersonaController(PersonaServiceImpl service) {
        super(service);
    }


}
