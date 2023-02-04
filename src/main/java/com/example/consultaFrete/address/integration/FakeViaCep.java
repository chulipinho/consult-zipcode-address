package com.example.consultaFrete.address.integration;

import org.springframework.stereotype.Component;

import com.example.consultaFrete.address.Address;

@Component("mockViaCep")
public class FakeViaCep implements ViaCepDAO{

    @Override
    public Address getZipcodeInformation(String zipcode) {
        return new Address("01001-000", "Praça da Sé", "lado ímpar", "Sé", "São Paulo", "SP");
    }
}
