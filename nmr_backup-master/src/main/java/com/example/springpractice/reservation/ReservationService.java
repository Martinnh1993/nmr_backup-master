package com.example.springpractice.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepo;


    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    public void saveReservation(Reservation reservation) {
        this.reservationRepo.save(reservation);
    }

    public Reservation getReservationById(int id){
        Optional<Reservation> optional = reservationRepo.findById(id);
        Reservation reservation = null;
        if(optional.isPresent()) {
            reservation = optional.get();
        } else {
            throw new RuntimeException(" Booking not found for id" + id);
        }
        return reservation;
    }

    public void deleteReservationById(int id) {
        this.reservationRepo.deleteById(id);
    }
}
