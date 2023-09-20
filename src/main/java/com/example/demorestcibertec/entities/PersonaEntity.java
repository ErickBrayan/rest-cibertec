package com.example.demorestcibertec.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persona")
public class PersonaEntity extends BaseEntity {

    private String name;
    @Column(name = "lastname")
    private String lastName;
    private String dni;

}
