package com.example.demorestcibertec.repositories;

import com.example.demorestcibertec.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity,Long> {

    PersonaRepository findByNameAndDni(String name,String dni);
}
