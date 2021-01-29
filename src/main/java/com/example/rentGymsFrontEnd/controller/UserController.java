package com.example.rentGymsFrontEnd.controller;

import com.example.rentGymsFrontEnd.dto.*;
import com.example.rentGymsFrontEnd.gateway.BankAccountGateway;
import com.example.rentGymsFrontEnd.gateway.UserGateway;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserGateway userGateway;
    private final BankAccountGateway bankAccountGateway;

    @Autowired
    public UserController(UserGateway userGateway, BankAccountGateway bankAccountGateway) {
        this.userGateway = userGateway;
        this.bankAccountGateway = bankAccountGateway;
    }

    @GetMapping("/user")
    public ModelAndView patient(ModelAndView mav, HttpSession httpSession) {
        mav.setViewName("user");

        UserDTO user =userGateway.findByID(1L);
        mav.addObject("user",user);

        return mav;
    }

    @PostMapping("/login")
    public String login(UserDTO userDTO, HttpSession httpSession) {
        System.out.println(userDTO);
        UserBankDTO user = userGateway.login(userDTO);
        System.out.println(user);
        httpSession.setAttribute("user", user);

        if (user == null) {
            return "redirect:/home?error";
        }
        if (user.getIs_admin().equals(true)) {
            return "redirect:/adminHome";
        } else {
            return "redirect:/home";
        }
    }
    @PostMapping("/register")
    public String register(UserBankDTO userBankDTO, HttpSession httpSession){
        UserDTO user = new UserDTO();
        System.out.println(userBankDTO);
        user.setEmail(userBankDTO.getEmail());
        user.setFirst_name(userBankDTO.getFirst_name());
        user.setIs_admin(false);
        user.setLast_name(userBankDTO.getLast_name());
        user.setPhone_number(userBankDTO.getPhone_number());
        user.setUsername(userBankDTO.getUsername());
        user.setPassword(userBankDTO.getPassword());

        Long user_id = userGateway.register(user);

        BankAccountDTO bankAccount = new BankAccountDTO();
        bankAccount.setAmount(userBankDTO.getAmount());
        bankAccount.setBank_number(userBankDTO.getBank_number());
        bankAccount.setSecurity_number(userBankDTO.getSecurity_number());
        bankAccount.setUser_id(user_id);
        BankAccountDTO bank = bankAccountGateway.save(bankAccount);
        System.out.println(bank);

        if(user_id == null) return "redirect:/login";
        else{
            UserDTO user1 = userGateway.findByID(user_id);
            UserBankDTO user2 = new UserBankDTO();
            user2.setEmail(user1.getEmail());
            user2.setFirst_name(user1.getFirst_name());
            user2.setLast_name(user1.getLast_name());
            user2.setPassword(user1.getPassword());
            user2.setUsername(user1.getUsername());
            user2.setIs_admin(user1.getIs_admin());
            user2.setUser_id(user1.getId());
            user2.setPhone_number(user1.getPhone_number());
            user2.setAmount(bank.getAmount());
            user2.setBank_id(bank.getId());
            user2.setBank_number(bank.getBank_number());
            user2.setSecurity_number(bank.getSecurity_number());
            httpSession.setAttribute("user",user2);
            return "redirect:/home";
        }
    }

    @GetMapping("/users")
    public ModelAndView nume8(ModelAndView modelAndView) {
        List<UserDTO> users = userGateway.findAll();
        for (UserDTO user:users) {
            System.out.println(user);
        }
        modelAndView.setViewName("users");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @PostMapping("/delete_user")
    public ModelAndView deleteUser(ModelAndView mav, HttpSession httpSession , SingletonDTO<String> arrayJSON) {

        Gson gson = new Gson();
        UserDTOG obj = gson.fromJson(arrayJSON.getContent(), UserDTOG.class);
        UserDTO user = userGateway.findByID(Long.parseLong(obj.getUser_id()));
        System.out.println("------->"+user);
        if(user==null){
            mav.setViewName("redirect:/home?error");
            return mav;
        }else{
            userGateway.delete(Long.parseLong(obj.getUser_id()));
            mav.setViewName("redirect:/users");
        }
        return mav;
    }
}
