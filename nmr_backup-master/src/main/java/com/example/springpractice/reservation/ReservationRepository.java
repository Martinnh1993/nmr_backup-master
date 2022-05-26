package com.example.springpractice.reservation;

import com.example.springpractice.motorhome.Motorhome;

import java.util.Date;

public class ReservationRepository {

    public void dateNotBetween(Date startDate, Date endDate){
    String checkDate = "SELECT motorhome.id ,name, type, make, model, beds, price FROM motorhome " +
                "left join reservation on reservation.motorhome_id = motorhome.id " +
                "WHERE cast('?'as date) and cast('?' as date) not between start_date and end_date";

    String getRest = "SELECT motorhome.id ,name, type, make, model, beds, price FROM motorhome" +
            "    WHERE not EXISTS (SELECT * FROM reservation" +
            "            WHERE  motorhome_id = motorhome.id)";

    }
}
