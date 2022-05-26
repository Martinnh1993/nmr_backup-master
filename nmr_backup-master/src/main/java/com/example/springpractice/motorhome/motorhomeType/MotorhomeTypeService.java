package com.example.springpractice.motorhome.motorhomeType;

import com.example.springpractice.motorhome.Motorhome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorhomeTypeService {

    @Autowired
    private MotorhomeTypeRepo motorhomeTypeRepo;

    public List<MotorhomeType> getAllTypes() {
        return motorhomeTypeRepo.findAll();
    }

    public void saveMotorhomeType(MotorhomeType motorhomeType) {
        this.motorhomeTypeRepo.save(motorhomeType);
    }

}
