package com.example.javaproject.exception;

public class BadRequestException extends Exception{

    public BadRequestException(String mensaje){
        super(mensaje);
    }
}
