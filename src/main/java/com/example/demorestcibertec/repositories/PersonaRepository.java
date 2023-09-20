package com.example.demorestcibertec.repositories;

import com.example.demorestcibertec.entities.PersonaEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends BaseRepository<PersonaEntity,Long> {
}
