package com.example.rentGymsFrontEnd.gateway;

import com.example.rentGymsFrontEnd.dto.BankAccountDTO;

public interface BankAccountGateway {

    BankAccountDTO findById(Long id);
    BankAccountDTO save(BankAccountDTO bankAccountDTO);
    BankAccountDTO findByUserId(Long user_id);
}
