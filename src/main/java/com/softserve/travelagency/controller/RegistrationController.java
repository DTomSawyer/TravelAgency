package com.softserve.travelagency.controller;

import com.softserve.travelagency.model.User;
import com.softserve.travelagency.model.util.Status;
import com.softserve.travelagency.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;

    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("user") @Validated User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "register";
        }
        /*if (!user.getPassword().equals(user.getPasswordConfirm())){
            model.addAttribute("passwordError", "Passwords don't match");
            return "registration";
        }*/
        user.setStatus(Status.ACTIVE);
        if (!userService.saveUser(user)) {
            //model.addAttribute("usernameError", "User already exists!");
            return "register";
        }

        return "redirect:/auth/login";
    }
}
