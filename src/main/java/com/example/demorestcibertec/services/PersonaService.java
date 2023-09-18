package com.example.demorestcibertec.services;

import com.example.demorestcibertec.entities.PersonaEntity;
import com.example.demorestcibertec.repositories.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaService implements BaseService<PersonaEntity>{

    private final PersonaRepository personaRepository;
    @Override
    @Transactional
    public List<PersonaEntity> findAll() throws Exception {
        try {
            return personaRepository.findAll();
        }catch (Exception e ){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public PersonaEntity findById(Long id) throws Exception {
        try {
            return personaRepository.findById(id).orElse(null);

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public PersonaEntity save(PersonaEntity personaEntity) throws Exception {
        try {
            return personaRepository.save(personaEntity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public PersonaEntity update(Long id, PersonaEntity personaEntity) throws Exception {
        try {
            Optional<PersonaEntity> optional = personaRepository.findById(id);
            PersonaEntity persona = optional.get();
            return personaRepository.save(persona);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (personaRepository.existsById(id)){
                personaRepository.deleteById(id);
                return true;
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());

        }
        return false;
    }
}
