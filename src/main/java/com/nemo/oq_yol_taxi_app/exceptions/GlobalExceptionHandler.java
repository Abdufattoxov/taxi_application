package com.nemo.oq_yol_taxi_app.exceptions;

import com.nemo.oq_yol_taxi_app.payLoad.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CustomBadRequestException.class)
    public ApiErrorResponse badRequest(CustomBadRequestException request){
        return new ApiErrorResponse(request.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CustomInternalErrorException.class)
    public ApiErrorResponse internalError(CustomInternalErrorException c){
        return new ApiErrorResponse(c.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomNotFoundException.class)
    public ApiErrorResponse notFound(CustomNotFoundException e){
        return new ApiErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidTokenException.class)
    public ApiErrorResponse invalidToken(InvalidTokenException e){
        return new ApiErrorResponse(e.getMessage(), HttpStatus.UNAUTHORIZED, LocalDateTime.now());
    }

    @ExceptionHandler(CustomAlreadyExistException.class)
    public ApiErrorResponse adminAlreadyExist(CustomAlreadyExistException a){
        return new ApiErrorResponse(a.getMessage(), HttpStatus.CONFLICT, LocalDateTime.now());
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ApiErrorResponse handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ApiErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
    }
}
