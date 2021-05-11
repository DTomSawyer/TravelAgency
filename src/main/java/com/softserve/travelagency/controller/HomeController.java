package com.softserve.travelagency.controller;


import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.service.HotelService;
import com.softserve.travelagency.service.OrderService;
import com.softserve.travelagency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/")
public class HomeController {

    RoomService roomService;
    OrderService orderService;
    HotelService hotelService;

    @Autowired
    HomeController(RoomService roomService, OrderService orderService, HotelService hotelService) {
        this.roomService = roomService;
        this.orderService = orderService;
        this.hotelService = hotelService;
    }

    @GetMapping("/home")
    public String countries(Model model) {
        model.addAttribute("countries", hotelService.getAllCountries());

        return "home";
    }

    @GetMapping("/available")
    public String booking(@RequestParam("country") String country,
                          @RequestParam("arrivalDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate arrivalDate,
                          @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate,
                          Model model) {
        model.addAttribute("available", roomService.getAvailableRooms(country, arrivalDate, departureDate));
        model.addAttribute("arrivalDate", arrivalDate);
        model.addAttribute("departureDate", departureDate);

        return "ava-rooms";
    }
    @PostMapping("/booking")
    public String booking(@ModelAttribute("room") Room room,
//                          @RequestParam("arrivalDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate arrivalDate,
//                          @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate,
                          Model model) {
        room.getHotel();
        return "home";
    }
}
