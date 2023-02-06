package com.example.consultaFrete.delivery;

import com.example.consultaFrete.address.Address;

public interface DeliveryFeeCalculator {
    public double calculate(Address address);
}