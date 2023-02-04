package com.example.consultaFrete.delivery;

import com.example.consultaFrete.types.State;

public interface DeliveryFeeCalculator {
    public double calculate(State state);
}