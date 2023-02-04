package com.example.consultaFrete.delivery;

import java.util.HashMap;

import com.example.consultaFrete.types.Region;
import com.example.consultaFrete.types.State;

public class DefaultDeliveryFeeCalculator implements DeliveryFeeCalculator {
    
    private final HashMap<Region, Double> prices = new HashMap<>();

    DefaultDeliveryFeeCalculator() {
        prices.put(Region.NORTE, 20.83);
        prices.put(Region.NORDESTE, 15.98);
        prices.put(Region.SUDESTE, 7.85);
        prices.put(Region.CENTRO_OESTE, 12.50);
        prices.put(Region.SUL, 17.30);
    }

    @Override
    public double calculate(State state) {
        return prices.get(state.getRegion());
    }
}
