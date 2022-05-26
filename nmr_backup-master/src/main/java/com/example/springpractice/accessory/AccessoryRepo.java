package com.example.springpractice.accessory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoryRepo extends JpaRepository<Accessory, Integer> {
}
