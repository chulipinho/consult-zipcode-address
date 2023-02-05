package com.example.consultaFrete.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;

@RequestMapping("v1/consulta-endereco")
@RestController
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<ResponseAddress> consultAddress(@Valid @Nonnull @RequestBody AddressRequestBody body) {
        return new ResponseEntity<ResponseAddress>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "{cep}")
    public ResponseEntity<ResponseAddress> consultAddress(@Nonnull @PathVariable String cep) {
        return new ResponseEntity<ResponseAddress>(HttpStatus.OK);
    }
}