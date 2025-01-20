package com.Captura.Leads.Exceptions;

public class TurmaNotFoundException extends RuntimeException{
    public TurmaNotFoundException(String message){
        super(message);
    }
}
