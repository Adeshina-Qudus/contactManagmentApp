package org.management.utils;

import org.management.data.model.ContactApp;
import org.management.dtos.requests.RegisterRequest;

public class Mapper {


    public static ContactApp map(RegisterRequest registerRequest) {
        ContactApp newContactApp = new ContactApp();

        newContactApp.setFirstname(registerRequest.getFirstname());
        newContactApp.setLastname(registerRequest.getLastname());
        newContactApp.setEmail(registerRequest.getEmail());
        newContactApp.setPassword(registerRequest.getPassword());
        newContactApp.setPassword(registerRequest.getPassword());
        return newContactApp;
    }
}
