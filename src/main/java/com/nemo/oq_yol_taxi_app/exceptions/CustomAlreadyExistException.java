package com.nemo.oq_yol_taxi_app.exceptions;

public class CustomAlreadyExistException extends RuntimeException{
    public CustomAlreadyExistException(String message){
        super(message);
    }
}
