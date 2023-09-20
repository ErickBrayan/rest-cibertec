package com.example.demorestcibertec.controllers;

import com.example.demorestcibertec.entities.AutorEntity;
import com.example.demorestcibertec.services.AutorServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/autores")
public class AutorController extends BaseControllerImpl<AutorEntity, AutorServiceImpl> {

    public AutorController(AutorServiceImpl service) {
        super(service);
    }
}
