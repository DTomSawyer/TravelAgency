package com.softserve.travelagency.controller;

import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.service.HotelService;
import com.softserve.travelagency.service.OrderService;
import com.softserve.travelagency.service.RoomService;
import com.softserve.travelagency.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/management")
@AllArgsConstructor
public class ManagementController {

    private final UserService userService;
    private final HotelService hotelService;
    private final RoomService roomService;
    private final OrderService orderService;

    @GetMapping("/manage")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String manage(Model model) {
        return "management";
    }

    @GetMapping("/addHotel")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String newHotel(Model model) {
        model.addAttribute("countries", hotelService.getAllCountries());
        return "new-hotel";
    }

    @PostMapping("/addHotel")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String addHotel(@ModelAttribute("hotel") Hotel hotel) {
        hotelService.addHotel(hotel);
        return "redirect:/management/manage";
    }

    @GetMapping("/addRoom")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String newRoom(Model model) {
        model.addAttribute("hotels", hotelService.getAllHotels());
        return "new-room";
    }

    @PostMapping("/addRoom")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String addRoom(@ModelAttribute("room") Room room) {
        roomService.addRoom(room);
        return "redirect:/management/manage";
    }

    @GetMapping("/getUsers")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all-users";
    }

    @GetMapping("/getOrders")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String getOrders(@RequestParam("userId") Long userId, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        return "orders-list";
    }
}
