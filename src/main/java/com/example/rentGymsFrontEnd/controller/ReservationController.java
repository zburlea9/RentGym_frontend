package com.example.rentGymsFrontEnd.controller;


import com.example.rentGymsFrontEnd.dto.*;
import com.example.rentGymsFrontEnd.gateway.BankAccountGateway;
import com.example.rentGymsFrontEnd.gateway.PaymentGateway;
import com.example.rentGymsFrontEnd.gateway.ReservationGateway;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/")
public class ReservationController {
    private final ReservationGateway reservationGateway;
    private final PaymentGateway paymentGateway;
    private final BankAccountGateway bankAccountGateway;

    public ReservationController(ReservationGateway reservationGateway, PaymentGateway paymentGateway, BankAccountGateway bankAccountGateway) {
        this.reservationGateway = reservationGateway;
        this.paymentGateway = paymentGateway;
        this.bankAccountGateway = bankAccountGateway;
    }

    @GetMapping("/reservations")
    public ModelAndView reservations(ModelAndView modelAndView, HttpSession httpSession) {
        UserBankDTO user = (UserBankDTO) httpSession.getAttribute("user");
        List<ReservationDTO> reservations = reservationGateway.findAllReservationsUser(user.getUser_id());
        for (ReservationDTO reservation:reservations) {
            System.out.println(reservation);
        }
        modelAndView.setViewName("reservations");
        modelAndView.addObject("reservations", reservations);
        return modelAndView;
    }

    @PostMapping("/reserve_gym")
    public String reserve_gym(ReservationAndPaymentDTO reservationAndPaymentDTO, HttpSession httpSession){
        System.out.println(reservationAndPaymentDTO);
        UserBankDTO user = (UserBankDTO) httpSession.getAttribute("user");
        GymDTO gym = (GymDTO) httpSession.getAttribute("gym_view");
        if(user.getAmount() - gym.getPrice() < 0){
            return "redirect:/home?error";
        }else{
            PaymentDTO paymentDTO = new PaymentDTO();
            paymentDTO.setUser_id(user.getUser_id());
            paymentDTO.setValue(gym.getPrice());
            PaymentDTO paymentSaved = paymentGateway.save(paymentDTO);
            if(paymentSaved==null)
                return "redirect:/home?error";
            else{
                ReservationDTO reservationDTO = new ReservationDTO();

                String[] dateString = reservationAndPaymentDTO.getDate().split("/");
                int year = Integer.parseInt(dateString[2]);
                int day = Integer.parseInt(dateString[1]);
                int month = Integer.parseInt(dateString[0]);
                LocalDate date = LocalDate.of(year, month, day);

                reservationDTO.setDate(date);
                reservationDTO.setHour(reservationAndPaymentDTO.getHour());

                reservationDTO.setGym_id(gym.getId());
                reservationDTO.setPayment_id(paymentSaved.getId());
                reservationDTO.setUser_id(user.getUser_id());
                ReservationDTO reservationSaved = reservationGateway.save(reservationDTO);

                if(reservationSaved==null)
                    return "redirect:/home?error";
                else{
                    BankAccountDTO bankAccount = new BankAccountDTO();
                    bankAccount.setUser_id(user.getUser_id());
                    bankAccount.setSecurity_number(user.getSecurity_number());
                    bankAccount.setId(user.getBank_id());
                    bankAccount.setBank_number(user.getBank_number());
                    bankAccount.setAmount(user.getAmount() - gym.getPrice());
                   BankAccountDTO bankUpdated =  bankAccountGateway.save(bankAccount);

                    user.setAmount(bankUpdated.getAmount());
                    httpSession.setAttribute("user", user);

                    return "redirect:/reservations";
                }
            }
        }
    }
}
