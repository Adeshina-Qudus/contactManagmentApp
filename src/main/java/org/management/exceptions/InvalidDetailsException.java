package org.management.exceptions;

public class InvalidDetailsException extends RuntimeException {

    public  InvalidDetailsException(){
        super("Login credentials is invalid");
    }
}
