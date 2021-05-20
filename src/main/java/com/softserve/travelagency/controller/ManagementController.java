package com.softserve.travelagency.controller;

import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.model.User;
import com.softserve.travelagency.model.util.RoomType;
import com.softserve.travelagency.service.HotelService;
import com.softserve.travelagency.service.OrderService;
import com.softserve.travelagency.service.RoomService;
import com.softserve.travelagency.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Types;
import javax.validation.Valid;

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
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("countries", hotelService.getAllCountries());
        return "new-hotel";
    }

    @PostMapping("/addHotel")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String addHotel(@ModelAttribute("hotel") @Valid Hotel hotel, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("hotel", new Hotel());
            model.addAttribute("countries", hotelService.getAllCountries());
            return "new-hotel";
        }

        if (hotelService.addHotel(hotel)) {
            return "redirect:/management/manage";
        } else {
            String message = "Hotel already exists!";
            model.addAttribute("message", message);
            return "new-hotel";
        }
    }

    /*@PostMapping("/addHotel")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String addHotel(@ModelAttribute("hotel") @Valid Hotel hotel, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "redirect:/management/addHotel";
        }

        if (hotelService.addHotel(hotel)) {
            model.addAttribute("message", "Hotel already exists!");
            return "redirect:/management/manage";
        }
        return "redirect:/management/addHotel";
    }*/

    @GetMapping("/addRoom")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String newRoom(Model model) {
        model.addAttribute("room", new Room());
        model.addAttribute("hotels", hotelService.getAllHotels());
        model.addAttribute("types", RoomType.values());
        return "new-room";
    }

    @PostMapping("/addRoom")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String addRoom(@RequestParam String hotelName,
                          @RequestParam String type,
                          @RequestParam Integer number,
                          @RequestParam Double price,
                          BindingResult bindingResult, Model model) {

        Hotel hotel = hotelService.getHotelByName(hotelName);
        Room room = Room.builder()
                .hotel(hotel)
                .type(RoomType.valueOf(type))
                .number(number)
                .price(price)
                .build();

        if (bindingResult.hasErrors()) {
            return "redirect:/management/addRoom";
        }

        if (roomService.addRoom(room)) {
            return "redirect:/management/manage";
        }
        return "redirect:/management/addRoom";
    }

    /*@PostMapping("/addRoom")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String addRoom(@ModelAttribute("room") @Valid Room room, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/management/addRoom";
        }

        if (roomService.addRoom(room)) {
            return "redirect:/management/manage";
        }
        return "redirect:/management/addRoom";
    }*/

    @GetMapping("/getUsers")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all-users";
    }

    @GetMapping("/getOrders/{userId}")
    @PreAuthorize("hasAuthority('developers:edit')")
    public String getOrders(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        model.addAttribute("orders", orderService.getOrdersByUserId(userId));
        return "orders-list";
    }

}
