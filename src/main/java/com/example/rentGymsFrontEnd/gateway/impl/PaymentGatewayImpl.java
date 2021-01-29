package com.example.rentGymsFrontEnd.gateway.impl;

import com.example.rentGymsFrontEnd.config.RestProperties;
import com.example.rentGymsFrontEnd.dto.PaymentDTO;
import com.example.rentGymsFrontEnd.dto.UserDTO;
import com.example.rentGymsFrontEnd.gateway.PaymentGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentGatewayImpl implements PaymentGateway {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserGatewayImpl.class);
    private final String URL = "/payment";
    private final RestProperties restProperties;

    @Autowired
    public PaymentGatewayImpl(RestProperties restProperties) {
        this.restProperties = restProperties;
    }

    @Override
    public PaymentDTO save(PaymentDTO paymentDTO) {
        LOGGER.info("Executing save method");
        String url = restProperties.getUrl() + URL + "/save";
        HttpEntity<Object> httpEntity = new HttpEntity<>(paymentDTO);
        RestTemplate restTemplate = new RestTemplate();
        PaymentDTO response = restTemplate.postForObject(url, httpEntity, PaymentDTO.class);
        return response;
    }
}
