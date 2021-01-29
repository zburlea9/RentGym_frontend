package com.example.rentGymsFrontEnd.controller;

import com.example.rentGymsFrontEnd.dto.GymDTO;
import com.example.rentGymsFrontEnd.dto.UserBankDTO;
import com.example.rentGymsFrontEnd.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class WelcomeController {

    @GetMapping("/home")
    public ModelAndView nume1(ModelAndView modelAndView, HttpSession httpSession) {
        modelAndView.setViewName("home");
        UserBankDTO user = (UserBankDTO) httpSession.getAttribute("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/profile")
    public ModelAndView nume3(ModelAndView modelAndView, HttpSession httpSession) {
        UserBankDTO user = (UserBankDTO) httpSession.getAttribute("user");
        modelAndView.addObject("user", user);
        modelAndView.setViewName("profile");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView nume5(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/addGym")
    public ModelAndView nume13(ModelAndView modelAndView) {
        modelAndView.setViewName("addGym");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView nume6(ModelAndView modelAndView) {
        modelAndView.setViewName("register");
        return modelAndView;
    }


    @GetMapping("/adminHome")
    public ModelAndView nume7(ModelAndView modelAndView) {
        modelAndView.setViewName("adminHome");
        return modelAndView;
    }

    @GetMapping("/privacy")
    public ModelAndView nume10(ModelAndView modelAndView) {
        modelAndView.setViewName("privacy");
        return modelAndView;
    }
    @GetMapping("/gym")
    public ModelAndView nume11(ModelAndView modelAndView, HttpSession httpSession) {
        GymDTO gym = (GymDTO) httpSession.getAttribute("gym_view");
        modelAndView.addObject("gym_view", gym);
        modelAndView.setViewName("gym");
        return modelAndView;
    }
}
