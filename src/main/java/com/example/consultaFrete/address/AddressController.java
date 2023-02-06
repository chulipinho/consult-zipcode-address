package com.example.consultaFrete.address;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Consulta endereço")
@RequestMapping("v1/consulta-endereco")
@RestController
public class AddressController {
    private final AddressService addressService;
    
    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }
    
    @ApiOperation("Retorna um objeto de endereço com o valor do frete baseado na região")
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ResponseAddress> consultAddress(@Valid @NotNull @RequestBody AddressRequestBody body) {
        ResponseAddress response = addressService.getResponseAddress(body.getCep());
        
        return new ResponseEntity<ResponseAddress>(response, HttpStatus.OK);
    }
    
    @ApiOperation("Retorna um objeto de endereço com o valor do frete baseado na região")
    @GetMapping(path = "{cep}", produces = "application/json")
    public ResponseEntity<ResponseAddress> consultAddress(@NotNull @PathVariable String cep) {
        ResponseAddress response = addressService.getResponseAddress(cep);

        return new ResponseEntity<ResponseAddress>(response, HttpStatus.OK);
    }
}