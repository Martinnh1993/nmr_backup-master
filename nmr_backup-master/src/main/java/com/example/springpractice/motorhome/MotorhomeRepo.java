package com.example.springpractice.motorhome;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotorhomeRepo extends JpaRepository<Motorhome, Integer> {
}
