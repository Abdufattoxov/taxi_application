package com.nemo.oq_yol_taxi_app.exceptions;

public class CustomInternalErrorException extends RuntimeException{
    public CustomInternalErrorException(String message){
        super(message);
    }
}
