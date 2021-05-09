package com.softserve.travelagency.controller;

import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.service.OrderService;
import com.softserve.travelagency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    RoomService roomService;
    OrderService orderService;

    @Autowired
    RoomController(RoomService roomService,OrderService orderService){
        this.roomService = roomService;
        this.orderService = orderService;
    }

    @GetMapping("/add")
    public String addNewRoom(Model model){

        Order order = new Order();
//        Room room = new Room();


        order.setArrivalDate(LocalDate.of(2021,5,13));
        order.setDepartureDate(LocalDate.of(2021,5,15));
//        order.setRooms(Arrays.asList(room));



//        roomService.saveRoom(room);
        orderService.addOrder(order);

        return "add-rooms";
    }

    @ResponseBody
    @GetMapping("/getOrder")
    public String getOrder(Model model){
        roomService.getAvailableRooms(LocalDate.of(2021,5,13),LocalDate.of(2021,5,15));
        return "works";
    }


//    @PostMapping("/add")
//    public String addNewRoom(@ModelAttribute Room room,@ModelAttribute Order order){
//        roomService.saveRoom(room);
//        return "redirect:/add";
//    }

}