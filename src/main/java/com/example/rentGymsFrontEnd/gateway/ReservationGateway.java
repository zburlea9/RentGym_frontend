package com.example.rentGymsFrontEnd.gateway;

import com.example.rentGymsFrontEnd.dto.GymDTO;
import com.example.rentGymsFrontEnd.dto.ReservationDTO;

import java.util.List;

public interface ReservationGateway {

    ReservationDTO save(ReservationDTO reservationDTO);

    List<ReservationDTO> findAll();
    List<ReservationDTO> findAllReservationsUser(Long id);
}
