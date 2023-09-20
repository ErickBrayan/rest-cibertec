package com.example.demorestcibertec.services;

import com.example.demorestcibertec.entities.AutorEntity;
import com.example.demorestcibertec.repositories.AutorRepository;
import com.example.demorestcibertec.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl extends BaseServiceImpl<AutorEntity,Long> {

    @Autowired
    private AutorRepository autorRepository;
    public AutorServiceImpl(BaseRepository<AutorEntity, Long> baseRepository) {
        super(baseRepository);
    }



}
