package org.management.utils;

import org.management.data.model.ContactManagement;
import org.management.dtos.requests.RegisterRequest;

public class Mapper {


    public static ContactManagement map(RegisterRequest registerRequest) {
        ContactManagement newContactApp = new ContactManagement();
        newContactApp.setName(registerRequest.getName());
        newContactApp.setEmail(registerRequest.getEmail());
        newContactApp.setPhoneNumber(registerRequest.getPhoneNumber());
        newContactApp.setPassword(registerRequest.getPassword());
        return newContactApp;
    }
}
