package com.softserve.travelagency.controller;

import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.service.HotelService;
import com.softserve.travelagency.service.OrderService;
import com.softserve.travelagency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    RoomService roomService;
    OrderService orderService;
    HotelService hotelService;

    @Autowired
    RoomController(RoomService roomService,OrderService orderService,HotelService hotelService){
        this.roomService = roomService;
        this.orderService = orderService;
        this.hotelService = hotelService;
    }
//
//    @GetMapping("/add")
//    public String addNewRoom(Model model){

//        Order order = new Order();
//        Room room = new Room.RoomBuilder()
//                .

//
//        order.setArrivalDate(LocalDate.of(2021,5,13));
//        order.setDepartureDate(LocalDate.of(2021,5,15));
//        order.setRooms(Arrays.asList(roomService.getRoomById(10L)));
//
//
//
////        roomService.saveRoom(room);
//        orderService.addOrder(order);
//
//        return "add-rooms";
//    }

    @ResponseBody
    @GetMapping("/add/hotel")
    public String addNewHotel(){
        Hotel hotel = Hotel.builder().city("Lviv").country("Ukraine").name("Orest's hotel").build();
        hotelService.addHotel(hotel);
        return "add";
    }

    //  @ResponseBody
    @GetMapping("/getOrder")
    public String getOrder(Model model){
        List<Room> roomList = roomService.getAvailableRooms(LocalDate.of(2021,5,20),LocalDate.of(2021,5,25));
        model.addAttribute("rooms",roomList);
        return "show-query";
    }


//    @PostMapping("/add")
//    public String addNewRoom(@ModelAttribute Room room,@ModelAttribute Order order){
//        roomService.saveRoom(room);
//        return "redirect:/add";
//    }

}