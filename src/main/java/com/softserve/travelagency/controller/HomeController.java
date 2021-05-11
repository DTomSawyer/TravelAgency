package com.softserve.travelagency.controller;


import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.service.HotelService;
import com.softserve.travelagency.service.OrderService;
import com.softserve.travelagency.service.RoomService;
import org.dom4j.rule.Mode;
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
        model.addAttribute("country", country);

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

    /*@GetMapping("/book/{hotelId}/{roomId}")
    public String bookRoom(@PathVariable Long hotelId, @PathVariable Long roomId,
                           @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
                           @ModelAttribute("arrivalDate") LocalDate arrivalDate,
                           @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
                               @ModelAttribute("departureDate") LocalDate departureDate,
                           Model model) {

        Order order = Order.builder()
                .hotel(hotelService.getHotelById(hotelId))
                .room(roomService.getRoomById(roomId))
                .arrivalDate(arrivalDate)
                .departureDate(departureDate)
                .orderDate(LocalDate.now())
                .build();

        model.addAttribute("order", order);

        //orderService.addOrder(order);

        return "book-confirm";
    }*/

    @PostMapping("/book")
    public String bookRoom(/*@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
                           @ModelAttribute("arrivalDate") LocalDate arrivalDate,
                           @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
                           @ModelAttribute("departureDate") LocalDate departureDate,*/
                           @RequestParam Long roomId,
                           Model model) {

        Room room = roomService.getRoomById(roomId);

        Order order = Order.builder()
                .hotel(room.getHotel())
                .room(room)
                .arrivalDate(LocalDate.now()/*arrivalDate*/)
                .departureDate(LocalDate.now()/*departureDate*/)
                .orderDate(LocalDate.now())
                .build();

        model.addAttribute("order", order);

        orderService.addOrder(order);

        return "book-confirm";
    }
}
