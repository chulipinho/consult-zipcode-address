package com.example.consultaFrete.address;

import lombok.Getter;

public class ResponseAddress extends Address{

    @Getter private double deliveryFee;

    public ResponseAddress(String zipcode, String street, String complement, String district, String city,
            String state, double deliveryFee) {
        super(zipcode, street, complement, district, city, state);

        this.deliveryFee = deliveryFee;
    }
}
