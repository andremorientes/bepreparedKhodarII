package com.morientesdev.beprepare.exception;

public class EntityNotFoundException extends  BadRequestException{

    public EntityNotFoundException(String message){
        super(message);
    }
}
