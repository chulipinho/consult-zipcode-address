package com.example.consultaFrete.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/consulta-endereco")
@RestController
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @PostMapping
    public void consultAddress(@RequestBody Address body) {
        
    }

    @GetMapping(path = "{cep}")
    public void consultAddress(@PathVariable String cep) {
        
    }
}