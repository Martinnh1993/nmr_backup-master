package com.example.springpractice.motorhome.motorhomeType;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class MotorhomeType {

    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    @Column(unique = true)
    @NotEmpty(message = "Type can't be empty")
    String type;
}
