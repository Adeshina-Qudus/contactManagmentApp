package org.management.service;

import org.management.data.model.ContactApp;
import org.management.data.repository.ContactAppRepository;
import org.management.dtos.requests.LoginRequest;
import org.management.exceptions.InvalidDetailsException;
import org.management.exceptions.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.management.dtos.requests.RegisterRequest;

import static org.management.utils.Mapper.map;

@Service
public class ContactAppServiceImpl implements ContactAppService {
    @Autowired
    private ContactAppRepository contactAppRepository;

    @Override
    public void registration(RegisterRequest registerRequest) {
        if (userExist(registerRequest.getEmail())) throw new UserExistException(registerRequest.getEmail() + "already exist");
        ContactApp contactApp = map(registerRequest);
        contactAppRepository.save(contactApp);
    }
    private boolean userExist(String email) {
        ContactApp foundAccount = contactAppRepository.findByEmail(email);
        return foundAccount != null;
    }
    @Override
    public void login(LoginRequest loginRequest) {
    }

    @Override
    public void addContact(String firstname, String lastname, String phoneNumber) {

    }

    @Override
    public void deleteContact(String phoneNumber, String password) {

    }

    @Override
    public void editProfile(String firstname, String lastname) {

    }

    @Override
    public void deleteProfile(String firstname, String lastname) {

    }

    @Override
    public void findContact(String firstname, String lastname, String phoneNumber) {

    }

    @Override
    public void findAllContact(String password) {

    }
}
