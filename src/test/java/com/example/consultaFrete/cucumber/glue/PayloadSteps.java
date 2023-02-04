package com.example.consultaFrete.cucumber.glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PayloadSteps {
    @When("the user enters a zipcode {}")
    public void givenTheUserEntersANullValue(String input) {
    }

    @Then("the API must throw an exception")
    public void thenTheApiMustThrowAnException() {
    }

    @Then("the API must find the address")
    public void thenTheApiMustFindTheAddress() {
    }

    @Then("the API must not find the address")
    public void thenTheApiMustNotFindTheAddress() {
    }

    @And("return it along with the delivery price")
    public void andReturnItAlongWithTheDeliveryPrice() {
    }

    @And("return a zipcode not found message") 
    public void andReturnAZipcodeNotFoundMessage() {
    }

    @And("return a badRequest status code")
    public void andReturnABadRequestStatusCode() {
    }
}