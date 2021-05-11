package com.softserve.travelagency.controller;


import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.service.HotelService;
import com.softserve.travelagency.service.OrderService;
import com.softserve.travelagency.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class HomeController {

    RoomService roomService;
    OrderService orderService;
    HotelService hotelService;

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

    @PostMapping("/book")
    public String bookRoom(@RequestParam Long roomId,
                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate arrivalDate,
                           @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate,
                           Model model) {

        Room room = roomService.getRoomById(roomId);

        Order order = Order.builder()
                .hotel(room.getHotel())
                .room(room)
                .arrivalDate(arrivalDate/*LocalDate.parse(arrivalDate)*/)
                .departureDate(departureDate/*LocalDate.parse(departureDate)*/)
                .orderDate(LocalDate.now())
                .build();

        model.addAttribute("order", order);

        orderService.addOrder(order);

        return "order";
    }
}
