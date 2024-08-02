package com.nemo.oq_yol_taxi_app.exceptions;

public class CustomBadRequestException extends RuntimeException{
    public CustomBadRequestException(String message){
        super(message);
    }
}
