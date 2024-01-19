package org.management.exceptions;

public class NameAlreadyExist extends ContactManagementException {
    public NameAlreadyExist(){
        super("Name Already Exist ");
    }
}
