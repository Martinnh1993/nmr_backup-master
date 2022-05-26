package com.example.springpractice.motorhome;

import com.example.springpractice.motorhome.motorhomeType.MotorhomeType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Motorhome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;
    private String name;

    @OneToOne
    @JoinColumn(name = "type", referencedColumnName = "id")
    private MotorhomeType motorhomeType;

    @NotEmpty(message = "Make cant be empty")
    private String make;

    @NotEmpty(message = "Model can't be empty")
    private String model;

    @NotNull(message = "Beds can't be null")
    private int beds;

    @NotNull(message = "price can't be null")
    private double price;

}
