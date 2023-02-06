package com.example.consultaFrete.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressRequestBody {
    @Getter 
    @Size(max = 8, message = "Por favor insira um CEP válido")
    private String cep;

    public AddressRequestBody(@JsonProperty("cep") String cep) {
        String cleanZipcode = cep.replaceAll("[^\\d]", "");

        this.cep = padLeftZeros(cleanZipcode, 8);
    }

    private String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);
    
        return sb.toString();
    }
}
