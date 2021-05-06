package com.softserve.travelagency.controller;


import com.softserve.travelagency.dao.UserDAO;
import com.softserve.travelagency.dao.impl.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/home")
@Controller
public class UserController {

    private final UserDAO userDAO;

    @Autowired
    UserController(UserDAOImpl userDAO){
    this.userDAO = userDAO;
    }

    @GetMapping("/all")
    public String showAllUsers(Model model){
        model.addAttribute("users",userDAO.getAllUsers());
        return "all-users";
    }
}
