package com.example.rentGymsFrontEnd.gateway;

import com.example.rentGymsFrontEnd.dto.PaymentDTO;

public interface PaymentGateway {

    PaymentDTO save(PaymentDTO paymentDTO);
}
