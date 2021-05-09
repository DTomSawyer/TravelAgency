package com.softserve.travelagency.controller;


import com.softserve.travelagency.service.HotelService;
import com.softserve.travelagency.service.OrderService;
import com.softserve.travelagency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    RoomService roomService;
    OrderService orderService;
    HotelService hotelService;

    @Autowired
    HomeController(RoomService roomService,OrderService orderService,HotelService hotelService){
        this.roomService = roomService;
        this.orderService = orderService;
        this.hotelService = hotelService;
    }

    @GetMapping("/home")
    public String addNewRoom(Model model){
        model.addAttribute("hotels", hotelService.getAllHotels());
        model.addAttribute("countries", hotelService.getAllCountries());
        return "home";
    }
}
