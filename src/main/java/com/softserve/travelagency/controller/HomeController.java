package com.softserve.travelagency.controller;


import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.service.HotelService;
import com.softserve.travelagency.service.OrderService;
import com.softserve.travelagency.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/home")
@AllArgsConstructor
public class HomeController {

    RoomService roomService;
    OrderService orderService;
    HotelService hotelService;

    @GetMapping("/booking")
    @PreAuthorize("hasAuthority('developers:book')")
    public String countries(Model model) {
        model.addAttribute("countries", hotelService.getAllCountries());

        return "home";
    }

    @GetMapping("/available")
    @PreAuthorize("hasAuthority('developers:book')")
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

    @PostMapping("/book")
    @PreAuthorize("hasAuthority('developers:book')")
    public String bookRoom(@RequestParam Long roomId,
                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate arrivalDate,
                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate,
                           Model model) {

        Room room = roomService.getRoomById(roomId);

        Order order = Order.builder()
                .hotel(room.getHotel())
                .room(room)
                .arrivalDate(arrivalDate)
                .departureDate(departureDate)
                .orderDate(LocalDateTime.now())
                .build();

        model.addAttribute("order", order);

        orderService.addOrder(order);

        return "order";
    }
}
