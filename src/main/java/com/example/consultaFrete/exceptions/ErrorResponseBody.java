package com.example.consultaFrete.exceptions;

import java.util.List;

import lombok.Getter;

public class ErrorResponseBody {
    @Getter private int status;
    @Getter private List<String> message;

    public ErrorResponseBody(int status, List<String> message) {
        this.status = status;
        this.message = message;
    }
}
