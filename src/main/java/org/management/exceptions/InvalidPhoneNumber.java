package org.management.exceptions;

public class InvalidPhoneNumber extends ContactManagementException {
    public InvalidPhoneNumber(){
        super("Phone number doesn't exist");
    }
}
