package com.example.demorestcibertec.services;

import com.example.demorestcibertec.entities.PersonaEntity;
import com.example.demorestcibertec.repositories.BaseRepository;
import com.example.demorestcibertec.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaServiceImpl extends BaseServiceImpl<PersonaEntity,Long> implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<PersonaEntity,Long> baseRepository){
        super(baseRepository);
    }

}
