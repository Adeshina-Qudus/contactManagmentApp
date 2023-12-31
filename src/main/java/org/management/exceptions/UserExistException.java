package org.management.exceptions;

import org.management.data.model.ContactApp;

public class UserExistException extends RuntimeException {
    public UserExistException(String message){
        super(message);
    }
}
