package org.practice01.exception;

public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
