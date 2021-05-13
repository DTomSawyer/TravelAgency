package com.softserve.travelagency.controller;

import com.softserve.travelagency.dao.OrderDAO;
import com.softserve.travelagency.dao.UserDAO;
import com.softserve.travelagency.dao.impl.UserDAOImpl;
import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.model.User;
import com.softserve.travelagency.model.util.Role;
import com.softserve.travelagency.model.util.RoomType;
import com.softserve.travelagency.service.HotelService;
import com.softserve.travelagency.service.OrderService;
import com.softserve.travelagency.service.RoomService;
import com.softserve.travelagency.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Date;
import java.util.Locale;

@RequestMapping("/home")
@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private OrderService orderService;
    private HotelService hotelService;
    private RoomService roomService;

    @GetMapping("/all")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "all-users";
    }

    /*@ResponseBody
    @GetMapping(value = "/add")
    public String addOrder() {
        User user = User.builder()
                .email("kwintiuk@icloud.com")
                .firstName("Nastya")
                .lastName("Kwintiuk")
                .password("1234567890")
                .role(Role.USER)
                .build();

        //userService.saveUser(user);

        Hotel hotel = Hotel.builder()
                .name("Rixos")
                .country("Egypt")
                .city("Hurgada")
                .build();

        //hotelService.addHotel(hotel);

        Room room = Room.builder()
                .hotel(hotelService.getHotelById(1L))
                .number(521)
                .type(RoomType.DELUXE)
                .price(400.0)
                .build();

        //roomService.saveRoom(room);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Order order = Order.builder()
                .user(userService.getUserById(1L))
                .hotel(hotelService.getHotelById(1L))
                .arrivalDate(LocalDate.parse("20-05-2021", df))
                .departureDate(LocalDate.parse("23-05-2021", df))
                .orderDate(LocalDate.now())
                .rooms(List.of(roomService.getRoomById(4L)))
                .build();

        //orderService.addOrder(order);

        //orderService.getOrderById(1L);
        return "Success";
    }*/
}
