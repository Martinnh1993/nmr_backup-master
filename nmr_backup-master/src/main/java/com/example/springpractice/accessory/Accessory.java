package com.example.springpractice.accessory;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
public class Accessory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double pricePerDay;
    private int available;
    private int rentedOut;
    private int totalStock;


    @Override
    public String toString() {
        return "Accessory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", available=" + available +
                ", rentedOut=" + rentedOut +
                ", totalStock=" + totalStock +
                '}';
    }
}
