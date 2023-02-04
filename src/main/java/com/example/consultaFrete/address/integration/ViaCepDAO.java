package com.example.consultaFrete.address.integration;

import com.example.consultaFrete.address.Address;

public interface ViaCepDAO {
    public Address getZipcodeInformation(String zipcode);    
}
