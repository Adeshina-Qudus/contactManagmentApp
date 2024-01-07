package org.management.exceptions;

public class InvalidPhoneNumber extends RuntimeException {
    public InvalidPhoneNumber(){
        super("Phone number doesn't exist");
    }
}
