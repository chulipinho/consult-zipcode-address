package com.example.consultaFrete.exceptions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseBody> handleValidationErrors(MethodArgumentNotValidException ex) {
        logger.error(ex.toString());
        
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());

        ErrorResponseBody body = new ErrorResponseBody(400, errors);
        
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    
    
    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ErrorResponseBody> handleAddressNotFoundError(AddressNotFoundException ex) {
        logger.error(ex.toString());

        ErrorResponseBody body = new ErrorResponseBody(404, messageAsList(ex.getMessage()));
        
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseBody> defaultExceptionHandler(Exception ex) {
        logger.error(ex.toString());
        
        String message = "Erro interno no servidor";
        
        ErrorResponseBody body = new ErrorResponseBody(500, messageAsList(message));
        
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    private List<String> messageAsList(String ...args) {
        return Arrays.asList(args);
    }
}