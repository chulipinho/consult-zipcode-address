package com.example.consultaFrete.address;

import com.example.consultaFrete.types.State;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    @JsonProperty("cep")
    @Setter @Getter private String zipcode;
    @JsonProperty("rua") 
    @Setter @Getter private String street;
    @JsonProperty("complemento")
    @Setter @Getter private String complement;
    @JsonProperty("bairro")
    @Setter @Getter private String district;
    @JsonProperty("cidade")  
    @Setter @Getter private String city;
    @JsonProperty("estado") 
    @Setter @Getter private State state;

    
    public Address() {}

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
        this.state = State.fromUF(state);
    }
}
