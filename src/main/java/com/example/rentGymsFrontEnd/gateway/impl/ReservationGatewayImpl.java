package com.example.rentGymsFrontEnd.gateway.impl;

import com.example.rentGymsFrontEnd.config.RestProperties;
import com.example.rentGymsFrontEnd.dto.GymDTO;
import com.example.rentGymsFrontEnd.dto.PaymentDTO;
import com.example.rentGymsFrontEnd.dto.ReservationDTO;
import com.example.rentGymsFrontEnd.gateway.ReservationGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ReservationGatewayImpl implements ReservationGateway {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserGatewayImpl.class);
    private final String URL = "/reservation";
    private final RestProperties restProperties;

    @Autowired
    public ReservationGatewayImpl(RestProperties restProperties) {
        this.restProperties = restProperties;
    }

    @Override
    public ReservationDTO save(ReservationDTO reservationDTO) {
        LOGGER.info("Executing save method");
        String url = restProperties.getUrl() + URL + "/save";
        HttpEntity<Object> httpEntity = new HttpEntity<>(reservationDTO);
        RestTemplate restTemplate = new RestTemplate();
        ReservationDTO response = restTemplate.postForObject(url, httpEntity, ReservationDTO.class);
        return response;
    }

    @Override
    public List<ReservationDTO> findAll() {
        LOGGER.info("Executing findAll method");
        String url = restProperties.getUrl() + URL + "/all";
        RestTemplate restTemplate = new RestTemplate();
        ReservationDTO[] response = restTemplate.getForObject(url, ReservationDTO[].class);
        if(response==null) return new ArrayList<>();

        return Arrays.asList(response);
    }

    @Override
    public List<ReservationDTO> findAllReservationsUser(Long id) {
        LOGGER.info("Executing findAll method");
        String url = restProperties.getUrl() + URL + "/allReservationUser/"+ id;
        RestTemplate restTemplate = new RestTemplate();
        ReservationDTO[] response = restTemplate.getForObject(url, ReservationDTO[].class);
        if(response==null) return new ArrayList<>();

        return Arrays.asList(response);
    }

}
