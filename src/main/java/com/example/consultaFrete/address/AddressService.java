package com.example.consultaFrete.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.consultaFrete.address.integration.ViaCepDAO;
import com.example.consultaFrete.delivery.DeliveryFeeCalculator;

@Service
public class AddressService {
    private final ViaCepDAO viaCepDAO;
    private final DeliveryFeeCalculator defaultDeliveryFeeCalculator;

    @Autowired
    public AddressService(@Qualifier("mockViaCep") ViaCepDAO viaCepDAO, @Qualifier("default") DeliveryFeeCalculator deliveryFeeCalculator) {
        this.viaCepDAO = viaCepDAO;
        this.defaultDeliveryFeeCalculator = deliveryFeeCalculator;
    }

    public ResponseAddress getResponseAddress(String zipcode) {
        Address addressFromZipcode = getAddress(zipcode);
        double deliveryFee = calculateDeliveryFee(addressFromZipcode);

        return ResponseAddress.fromAddress(addressFromZipcode, deliveryFee);
    }

    private Address getAddress(String zipcode) {
        return viaCepDAO.getZipcodeInformation(zipcode);
    }

    private double calculateDeliveryFee(Address address) {
        return defaultDeliveryFeeCalculator.calculate(address.getState());
    }
}
