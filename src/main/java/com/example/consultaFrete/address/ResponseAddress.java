package com.example.consultaFrete.address;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

public class ResponseAddress extends Address{
    @JsonProperty("frete")
    @Getter private double deliveryFee;

    public ResponseAddress() {
        super();
    }

    public ResponseAddress(String zipcode, String street, String complement, String district, String city,
            String state, double deliveryFee) {
        super(zipcode, street, complement, district, city, state);

        this.deliveryFee = deliveryFee;
    }

    public static ResponseAddress fromAddress(Address address, double deliveryFee) {
        return new ResponseAddress(
            address.getZipcode(),
            address.getStreet(),
            address.getComplement(),
            address.getDistrict(),
            address.getCity(),
            address.getState().toString(),
            deliveryFee
        );
    }
}
