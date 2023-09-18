package com.example.demorestcibertec.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "autor")
public class AutorEntity extends BaseEntity{

    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastName;
    @Column(length = 1500)
    private String biography;
}
