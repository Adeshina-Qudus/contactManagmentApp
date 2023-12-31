package org.management.service;

import org.management.dtos.requests.LoginRequest;
import org.management.dtos.requests.RegisterRequest;
import org.springframework.stereotype.Service;

@Service
public interface ContactAppService {

    void registration(RegisterRequest registerRequest);
    void login(LoginRequest loginRequest);
    void addContact(String firstname, String lastname, String phoneNumber);
    void deleteContact(String phoneNumber,String password);
    void editProfile(String firstname,String lastname);
    void deleteProfile(String firstname,String lastname);
    void findContact(String firstname, String lastname, String phoneNumber);
    void findAllContact(String password);

}
