package com.example.rentGymsFrontEnd.gateway.impl;

import com.example.rentGymsFrontEnd.config.RestProperties;
import com.example.rentGymsFrontEnd.dto.UserBankDTO;
import com.example.rentGymsFrontEnd.dto.UserDTO;
import com.example.rentGymsFrontEnd.gateway.UserGateway;
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
public class UserGatewayImpl implements UserGateway {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserGatewayImpl.class);
    private final String URL = "/user";
    private final RestProperties restProperties;

    @Autowired
    public UserGatewayImpl(RestProperties restProperties) {
        this.restProperties = restProperties;
    }

    @Override
    public UserDTO findByID(Long id) {
        LOGGER.info("Executing findById method, id=" + id);
        String url = restProperties.getUrl() + URL + "/find/" + id;
        RestTemplate restTemplate = new RestTemplate();
        UserDTO user = restTemplate.getForObject(url, UserDTO.class);
        System.out.println(user);
        return user;
    }

    @Override
    public List<UserDTO> findAll() {
        LOGGER.info("Executing findAll method");
        String url = restProperties.getUrl() + URL + "/all";
        RestTemplate restTemplate = new RestTemplate();
        UserDTO[] response = restTemplate.getForObject(url, UserDTO[].class);
        if(response==null) return new ArrayList<>();

        return Arrays.asList(response);
    }

    @Override
    public void delete(Long id) {
        String url = restProperties.getUrl() + URL + "/delete?id="+id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url, id);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        LOGGER.info("Executing save method");
        String url = restProperties.getUrl() + URL + "/save";
        HttpEntity<Object> httpEntity = new HttpEntity<>(userDTO);
        RestTemplate restTemplate = new RestTemplate();
        UserDTO response = restTemplate.postForObject(url, httpEntity, UserDTO.class);
        return response;
    }

    @Override
    public UserDTO findByUsername(String username) {
        LOGGER.info("Executing findById method, username=" + username);
        String url = restProperties.getUrl() + URL + "/findU?username=" + username;
        RestTemplate restTemplate = new RestTemplate();
        UserDTO user = restTemplate.getForObject(url, UserDTO.class);
        return user;
    }

    @Override
    public UserBankDTO login(UserDTO userDTO) {
        String url=restProperties.getUrl() + URL + "/login";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Object> httpEntity = new HttpEntity<>(userDTO);
        UserBankDTO user = restTemplate.postForObject(url,httpEntity,UserBankDTO.class);
        return user;
    }

    @Override
    public Long register(UserDTO userDTO) {
        LOGGER.info("Executing save method");
        String url1 = restProperties.getUrl() + URL + "/save";
        HttpEntity<Object> httpEntity = new HttpEntity<>(userDTO);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url1, httpEntity, UserDTO.class).getId();
    }
}
