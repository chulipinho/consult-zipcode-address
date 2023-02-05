package com.example.consultaFrete.address;

import com.example.consultaFrete.types.State;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    @JsonProperty("cep") 
    @Getter private String zipcode;

    @JsonProperty("rua") @JsonAlias("logradouro") 
    @Getter private String street;

    @JsonProperty("complemento") 
    @Getter private String complement;

    @JsonProperty("bairro") 
    @Getter private String district;

    @JsonProperty("cidade") @JsonAlias("localidade") 
    @Getter private String city;
    
    @JsonProperty("estado") @JsonAlias("uf") 
    @Getter private State state;
    
    public Address() {}

    public Address(
        String zipcode, 
        String street, 
        String complement, 
        String district, 
        String city, 
       String state
    ) {
        this.zipcode = zipcode;
        this.street = street;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.state = State.fromUF(state);
    }
}
