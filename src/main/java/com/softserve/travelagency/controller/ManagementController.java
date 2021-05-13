package com.softserve.travelagency.controller;


import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.service.HotelService;
import com.softserve.travelagency.service.OrderService;
import com.softserve.travelagency.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/management")
@AllArgsConstructor
public class ManagementController {

    private final UserService userService;
    private final HotelService hotelService;
    private final OrderService orderService;

    @GetMapping("/manage")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String manage(Model model) {

        return "management";
    }

    @PostMapping("/addHotel")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String addHotel(Model model) {
        return "redirect:/management/manage";
    }

    @PostMapping("/addRoom")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String addRoom(Model model) {
        return "redirect:/management/manage";
    }

    @GetMapping("/getUsersWithOrders")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String getUsersWithOrders(Model model) {

        return "";
    }

}
