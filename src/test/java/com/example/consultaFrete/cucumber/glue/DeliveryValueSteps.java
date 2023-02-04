package com.example.consultaFrete.cucumber.glue;

import org.junit.Assert;

import com.example.consultaFrete.delivery.DefaultDeliveryFeeCalculator;
import com.example.consultaFrete.types.State;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeliveryValueSteps {
    private DefaultDeliveryFeeCalculator defaultDeliveryFeeCalculator = new DefaultDeliveryFeeCalculator();
    private double deliveryFee;
    private String uf;

    @Before
    public void setup() {
        this.deliveryFee = 0.0;
    }

    @When("the API enters {} as an UF")
    public void WhenTheApiEntersAnUf(String uf) {
        this.uf = uf;
    }

    @Then("the DefaultDeliveryFeeCalculator calculate method is called")
    public void thenTheDefaultCalculateMethodIsCalled() {
        this.deliveryFee = defaultDeliveryFeeCalculator.calculate(State.fromUF(uf));
    }

    @And("it must return {double}")
    public void andItMustReturn(double value) {
        Assert.assertEquals(deliveryFee, value, 0.001);
    }
}
