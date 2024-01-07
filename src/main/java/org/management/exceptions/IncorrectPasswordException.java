package org.management.exceptions;

public class IncorrectPasswordException extends RuntimeException {
    public  IncorrectPasswordException(){
        super("Incorrect Password");
    }

}
