package com.softserve.travelagency.controller;


import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.service.HotelService;
import com.softserve.travelagency.service.OrderService;
import com.softserve.travelagency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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

    @GetMapping("/booking")
    public String booking(@RequestParam("country") String country,
                          @RequestParam("arrivalDate") LocalDate arrivalDate,
                          @RequestParam("departureDate") LocalDate departureDate,
                          Model model) {
        // підтягує ВСІ, треба виправити щоб підтягував по країнах
        model.addAttribute("available", roomService.getAvailableRooms(arrivalDate, departureDate));
        model.addAttribute("arrivalDate", arrivalDate);
        model.addAttribute("departureDate", departureDate);
        return "booking";
    }
}
