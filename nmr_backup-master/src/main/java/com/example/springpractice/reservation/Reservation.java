package com.example.springpractice.reservation;

import com.example.springpractice.Person;
import com.example.springpractice.accessory.Accessory;
import com.example.springpractice.customer.Customer;
import com.example.springpractice.motorhome.Motorhome;
import com.example.springpractice.motorhome.motorhomeType.MotorhomeType;
import javax.validation.*;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Reservation extends Person {

    @Column(name = "AoP")
    private int amountOfPeople;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate endDate;


    //@OneToOne
    //@JoinColumn(name = "motorhomeTypeId", referencedColumnName = "id")
    //private MotorhomeType motorhomeType;

    @OneToOne
    @JoinColumn(name = "motorhomeId", referencedColumnName = "id")
    private Motorhome motorhome;

    @OneToMany
    @JoinColumn(name = "accessory_id", referencedColumnName = "id")
    private List<Accessory> accessory;

}

