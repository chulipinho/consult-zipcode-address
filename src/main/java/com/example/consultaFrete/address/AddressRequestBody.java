package com.example.consultaFrete.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressRequestBody {
    @Getter 
    @NotBlank
    private String cep;

    public AddressRequestBody(@JsonProperty("cep") String cep) {
        this.cep = cep;
    }
}
