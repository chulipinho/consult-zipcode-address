package com.example.consultaFrete.address.integration;

import org.springframework.stereotype.Component;

import com.example.consultaFrete.address.Address;
import com.example.consultaFrete.exceptions.AddressNotFoundException;

@Component("mockViaCep")
public class FakeViaCep implements ViaCepDAO{

    @Override
    public Address getZipcodeInformation(String zipcode) throws RuntimeException {
        if (isZipcodeInvalid(zipcode)) {
            throw new AddressNotFoundException("Endereço não encontrado. Por favor confira o CEP digitado");
        }

        return new Address("01001-000", "Praça da Sé", "lado ímpar", "Sé", "São Paulo", "SP");
    }

    private boolean isZipcodeInvalid(String zipcode) {
        return zipcode.equals("00000000");
    }
}
