package com.example.springpractice.reservation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository <Reservation, Integer> {
}
