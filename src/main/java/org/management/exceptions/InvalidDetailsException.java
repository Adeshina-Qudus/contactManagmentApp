package org.management.exceptions;

public class InvalidDetailsException extends ContactManagementException{

    public  InvalidDetailsException(){
        super("Login credentials is invalid");
    }
}
