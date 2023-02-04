package com.example.consultaFrete.address.integration;

import com.example.consultaFrete.address.Address;

public class FakeViaCep implements ViaCepDAO{

    @Override
    public Address getZipcodeInformation(String zipcode) {
        return new Address("01001-000", "Praça da Sé", "lado ímpar", "Sé", "São Paulo", "SP");
    }
}
