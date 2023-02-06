package com.example.consultaFrete.address.integration;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.consultaFrete.address.Address;
import com.example.consultaFrete.exceptions.AddressNotFoundException;

@Component("ViaCep")
public class ViaCep implements ViaCepDAO {
    private final String URI = "https://viacep.com.br/ws/";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Address getZipcodeInformation(String zipcode) {
        try {
            String url = URI + zipcode + "/json";
            ResponseEntity<Address> response = restTemplate.getForEntity(url, Address.class);
            
            return response.getBody();
        } catch (RestClientException e) {
            throw new AddressNotFoundException("Endereço não encontrado. Por favor confira o CEP digitado");
        }
    }
}
