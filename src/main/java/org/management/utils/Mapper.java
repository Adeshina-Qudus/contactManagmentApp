package org.management.utils;

import org.management.data.model.ContactApp;
import org.management.dtos.requests.RegisterRequest;

public class Mapper {


    public static ContactApp map(RegisterRequest registerRequest) {
        ContactApp newContactApp = new ContactApp();
        newContactApp.setName(registerRequest.getName());
        newContactApp.setEmail(registerRequest.getEmail());
        newContactApp.setPhoneNumber(registerRequest.getPhoneNumber());
        newContactApp.setPassword(registerRequest.getPassword());
        return newContactApp;
    }
}
