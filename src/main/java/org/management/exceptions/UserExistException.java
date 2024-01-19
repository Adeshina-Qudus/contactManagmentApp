package org.management.exceptions;

public class UserExistException extends ContactManagementException {
    public UserExistException(String message){
        super(message);
    }
}
