package com.example.consultaFrete.cucumber.glue;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.example.consultaFrete.address.ResponseAddress;
import com.example.consultaFrete.cucumber.PayloadTestContants;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.minidev.json.JSONObject;

public class PayloadSteps {
    private RestTemplate restTemplate = new RestTemplate();

    private ResponseEntity<ResponseAddress> response;
    
    private PayloadSteps() {
        response = null;

        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) {
            }
        });
    }

    @When("the user enters a zipcode {}")
    public void whenTheUserEntersAZipcode(String input) {
        JSONObject body = new JSONObject();
        body.put("cep", input.replace("\"", ""));
        
        response = requestApi(body);
    }

    @Then("the API must return a badRequest status code")
    public void thenTheAPIMustReturnABadRequestStatusCode() {
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(HttpStatus.valueOf(400)));
    }
    
    @Then("the API must return it along with the delivery price")
    public void thenTheAPIMustReturnItAlongWithTheDeliveryPrice() {
        ResponseAddress address = response.getBody();
        
        assertNotNull(address);
        assertNotNull(address.getDeliveryFee());
    }
    
    @Then("the API must return a notFound status code")
    public void thenTheApiMustReturnAZipcodeNotFoundMessage() {
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(HttpStatus.valueOf(404)));
    }

    private ResponseEntity<ResponseAddress> requestApi(JSONObject body) {
        return restTemplate.postForEntity(PayloadTestContants.ADDRESS_URI,
                                          body, ResponseAddress.class
                                          );
    } 
}