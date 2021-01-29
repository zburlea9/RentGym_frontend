package com.example.rentGymsFrontEnd.gateway;

import com.example.rentGymsFrontEnd.dto.UserBankDTO;
import com.example.rentGymsFrontEnd.dto.UserDTO;

import java.util.List;

public interface UserGateway {

    UserDTO findByID(Long id);

    List<UserDTO> findAll();

    void delete(Long id);

    Long register(UserDTO userDTO);

    UserBankDTO login(UserDTO userDTO);

    UserDTO findByUsername(String username);

    UserDTO save(UserDTO userDTO);
}
