package com.example.springpractice.motorhome;

import com.example.springpractice.motorhome.motorhomeType.MotorhomeType;
import com.example.springpractice.motorhome.motorhomeType.MotorhomeTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorhomeService {

    @Autowired
    private MotorhomeRepo motorhomeRepo;

    @Autowired
    private MotorhomeRepository motorhomeRepository;

    @Autowired
    private MotorhomeTypeRepo motorhomeTypeRepo;

    public List<Motorhome> getAllMotorhomes() {
        return motorhomeRepo.findAll();
    }

    public void saveMotorhome(Motorhome motorhome) {
        this.motorhomeRepo.save(motorhome);
    }

    public Motorhome getMotorhomeById(int id){
        Optional<Motorhome> optional = motorhomeRepo.findById(id);
        Motorhome motorhome = null;
        if(optional.isPresent()) {
            motorhome = optional.get();
        } else {
            throw new RuntimeException("Motorhome not found for id " + id);
        }
        return motorhome;
    }

    public void deleteMotorhomeById(int id) {
        this.motorhomeRepo.deleteById(id);
    }

    public List<Motorhome> findAllByType(int id) {
        return motorhomeRepository.findAllByType(id);
    }

}
