package com.example.consultaFrete.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.consultaFrete.address.integration.ViaCepDAO;

@Service
public class AddressService {
    private final ViaCepDAO viaCepDAO;

    @Autowired
    public AddressService(@Qualifier("mockViaCep") ViaCepDAO viaCepDAO) {
        this.viaCepDAO = viaCepDAO;
    }

    private Address getAddress(String zipcode) {
        return viaCepDAO.getZipcodeInformation(zipcode);
    }
}
