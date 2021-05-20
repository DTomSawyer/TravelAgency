package com.softserve.travelagency.controller;

import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.model.User;
import com.softserve.travelagency.security.SecurityUser;
import com.softserve.travelagency.security.UserDetailsServiceImpl;
import com.softserve.travelagency.service.HotelService;
import com.softserve.travelagency.service.OrderService;
import com.softserve.travelagency.service.RoomService;
import com.softserve.travelagency.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/home")
@AllArgsConstructor
public class HomeController {

    private UserService userService;
    private RoomService roomService;
    private OrderService orderService;
    private HotelService hotelService;


    @GetMapping("/booking")
    @PreAuthorize("hasAuthority('developers:book')")
    public String countries(Model model) {
        model.addAttribute("countries", hotelService.getAllCountries());
        return "home";
    }

    @GetMapping("/available")
    @PreAuthorize("hasAuthority('developers:book')")
    public String getAvailableRooms(@RequestParam("country") String country,
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
                           Model model,
                           Principal principal) {

        Room room = roomService.getRoomById(roomId);

        User user = userService.getUserByEmail(principal.getName());
        Order order = Order.builder()
                .user(user)
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
