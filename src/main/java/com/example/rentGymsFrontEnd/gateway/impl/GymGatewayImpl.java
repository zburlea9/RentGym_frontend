package com.example.rentGymsFrontEnd.gateway.impl;

import com.example.rentGymsFrontEnd.config.RestProperties;
import com.example.rentGymsFrontEnd.dto.GymDTO;
import com.example.rentGymsFrontEnd.dto.UserDTO;
import com.example.rentGymsFrontEnd.gateway.GymGateway;
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
public class GymGatewayImpl implements GymGateway {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserGatewayImpl.class);
    private final String URL = "/gym";
    private final RestProperties restProperties;

    @Autowired
    public GymGatewayImpl(RestProperties restProperties) {
        this.restProperties = restProperties;
    }

    @Override
    public List<GymDTO> findAll() {
        LOGGER.info("Executing findAll method");
        String url = restProperties.getUrl() + URL + "/all";
        RestTemplate restTemplate = new RestTemplate();
        GymDTO[] response = restTemplate.getForObject(url, GymDTO[].class);
        if(response==null) return new ArrayList<>();

        return Arrays.asList(response);
    }

    @Override
    public GymDTO findById(Long id) {
        LOGGER.info("Executing findById method, id=" + id);
        String url = restProperties.getUrl() + URL + "/find/" + id;
        RestTemplate restTemplate = new RestTemplate();
        GymDTO gym = restTemplate.getForObject(url, GymDTO.class);
        //System.out.println(gym);
        return gym;
    }

    @Override
    public void delete(Long id) {
        String url = restProperties.getUrl() + URL + "/delete?id="+id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url, id);
    }

    @Override
    public GymDTO save(GymDTO gymDTO) {
        LOGGER.info("Executing save method");
        String url = restProperties.getUrl() + URL + "/save";
        HttpEntity<Object> httpEntity = new HttpEntity<>(gymDTO);
        RestTemplate restTemplate = new RestTemplate();
        GymDTO response = restTemplate.postForObject(url, httpEntity, GymDTO.class);
        return response;
    }
}
