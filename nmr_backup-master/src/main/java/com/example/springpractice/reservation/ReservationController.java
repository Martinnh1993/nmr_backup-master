package com.example.springpractice.reservation;

import com.example.springpractice.employee.Employee;
import com.example.springpractice.motorhome.Motorhome;
import com.example.springpractice.motorhome.MotorhomeRepo;
import com.example.springpractice.motorhome.MotorhomeService;
import com.example.springpractice.motorhome.motorhomeType.MotorhomeType;
import com.example.springpractice.motorhome.motorhomeType.MotorhomeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private MotorhomeTypeService motorhomeTypeService;

    @Autowired
    private MotorhomeService motorhomeService;


    //display list of employees
    @GetMapping("/viewReservationPage")
    public String viewReservationPage(Model model){
        model.addAttribute("listOfReservations",reservationService.getAllReservations());
        model.addAttribute("motorhome",motorhomeService.getAllMotorhomes());
        return "reservation/reservationPage";
    }

    //add new employee
    @GetMapping("/showNewReservationForm")
    public String showNewReservationForm(Model model) {
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        model.addAttribute("listOfMotorhomes",motorhomeService.getAllMotorhomes());
        return "reservation/newReservation";
    }

    @GetMapping("/selectMotorhome")
    public String showAvailableMotorhomes(Model model) {
        model.addAttribute("listOfMotorhomes",motorhomeService.getAllMotorhomes());
        return "reservation/selectMotorhome";
    }

    @PostMapping("/saveReservation")
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation) {
        reservationService.saveReservation(reservation);
        return "redirect:viewReservationPage";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("reservation") Reservation reservation) {
        reservationService.saveReservation(reservation);
        return "redirect:selectMotorhome";
    }

    @GetMapping("/showReservationUpdateForm/{id}")
    public String showReservationUpdateForm(@PathVariable(value = "id") int id, Model model) {
        Reservation reservation = reservationService.getReservationById(id);
        model.addAttribute("reservation",reservation);
        model.addAttribute("listOfMotorhomes", motorhomeService.getAllMotorhomes());
        return "reservation/updateReservation";
    }

    @GetMapping("/deleteReservation/{id}")
    public String deleteReservation(@PathVariable(value = "id")int id) {
        this.reservationService.deleteReservationById(id);
        return "redirect:/viewReservationPage";
    }

}
