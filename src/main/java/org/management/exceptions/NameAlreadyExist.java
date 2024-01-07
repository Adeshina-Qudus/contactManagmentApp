package org.management.exceptions;

public class NameAlreadyExist extends RuntimeException {
    public NameAlreadyExist(){
        super("Name Already Exist ");
    }
}
