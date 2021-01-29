package com.example.rentGymsFrontEnd.controller;

import com.example.rentGymsFrontEnd.dto.*;
import com.example.rentGymsFrontEnd.gateway.GymGateway;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class GymController {
    private final GymGateway gymGateway;

    public GymController(GymGateway gymGateway) {
        this.gymGateway = gymGateway;
    }


    @GetMapping("/gyms")
    public ModelAndView nume4(ModelAndView modelAndView) {
        List<GymDTO> gyms = gymGateway.findAll();
        for (GymDTO gym:gyms) {
            System.out.println(gym);
        }
        modelAndView.setViewName("gyms");
        modelAndView.addObject("gyms", gyms);
        return modelAndView;
    }


    @GetMapping("/allGyms")
    public ModelAndView nume9(ModelAndView modelAndView) {
        List<GymDTO> gyms = gymGateway.findAll();
        for (GymDTO gym:gyms) {
            System.out.println(gym);
        }
        modelAndView.setViewName("allGyms");
        modelAndView.addObject("allGyms", gyms);
        return modelAndView;
    }

    @PostMapping("/show_gym_details")
    public ModelAndView showGymDetails(ModelAndView mav, HttpSession httpSession , SingletonDTO<String> arrayJSON) {
        Gson gson = new Gson();
        GymDTOG obj = gson.fromJson(arrayJSON.getContent(), GymDTOG.class);
        GymDTO gym = gymGateway.findById(Long.parseLong(obj.getGym_id()));

        if(gym==null){
            mav.setViewName("redirect:/home?error");
            return mav;
        }else{
            httpSession.setAttribute("gym_view", gym);
            System.out.println("->>>>>>>>>>"+gym);
            mav.addObject("gym_view", gym);
            mav.setViewName("redirect:/gym");
        }
        return mav;
    }

    @PostMapping("/delete_gym")
    public ModelAndView deleteGym(ModelAndView mav, HttpSession httpSession , SingletonDTO<String> arrayJSON) {
        Gson gson = new Gson();
        GymDTOG obj = gson.fromJson(arrayJSON.getContent(), GymDTOG.class);
        GymDTO gym = gymGateway.findById(Long.parseLong(obj.getGym_id()));
        System.out.println("------->"+gym);
        if(gym==null){
            mav.setViewName("redirect:/home?error");
            return mav;
        }else{
            gymGateway.delete(Long.parseLong(obj.getGym_id()));
            mav.setViewName("redirect:/allGyms");
        }
        return mav;
    }

    @PostMapping("/addNewGym")
    public String addNewGym(GymDTO gymDTO, HttpSession httpSession){
        GymDTO gym = new GymDTO();
        gym.setDescription(gymDTO.getDescription());
        gym.setLocation(gymDTO.getLocation());
        gym.setPrice(gymDTO.getPrice());
        gym.setType(gymDTO.getType());
        gym.setName(gymDTO.getName());

        GymDTO response = gymGateway.save(gym);


        if(response == null) return "redirect:/addGym?error";
        else{
            return "redirect:/allGyms";
        }
    }

}
