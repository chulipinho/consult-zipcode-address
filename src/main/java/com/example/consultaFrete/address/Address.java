package com.example.consultaFrete.address;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

public class Address {
    @Getter private String zipcode;
    @Getter private String street;
    @Getter private String complement;
    @Getter private String district;
    @Getter private String city;
    @Getter private String state;
    
    public Address(
        @JsonProperty("cep") String zipcode, 
        @JsonProperty("rua") @JsonAlias("logradouro") String street, 
        @JsonProperty("complemento") String complement, 
        @JsonProperty("bairro") String district, 
        @JsonProperty("cidade") @JsonAlias("localidade") String city, 
        @JsonProperty("estado") @JsonAlias("uf") String state
    ) {
        this.zipcode = zipcode;
        this.street = street;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.state = state;
    }
}
