package com.example.rentGymsFrontEnd.gateway;

import com.example.rentGymsFrontEnd.dto.GymDTO;
import com.example.rentGymsFrontEnd.dto.UserDTO;

import java.util.List;

public interface GymGateway {

    List<GymDTO> findAll();

    GymDTO findById(Long id);

    void delete(Long id);

    GymDTO save(GymDTO gymDTO);
}
