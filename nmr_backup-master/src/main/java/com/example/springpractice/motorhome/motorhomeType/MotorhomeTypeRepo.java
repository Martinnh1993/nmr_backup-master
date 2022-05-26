package com.example.springpractice.motorhome.motorhomeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorhomeTypeRepo extends JpaRepository<MotorhomeType, Integer> {
}
