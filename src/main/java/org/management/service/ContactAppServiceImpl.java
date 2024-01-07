package org.management.service;

import org.management.data.model.Contact;
import org.management.data.model.ContactApp;
import org.management.data.repository.ContactAppRepository;
import org.management.dtos.requests.*;
import org.management.exceptions.InvalidDetailsException;
import org.management.exceptions.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.management.utils.Mapper.map; 

@Service
public class ContactAppServiceImpl implements ContactAppService {
    @Autowired
    private ContactAppRepository contactAppRepository;
    @Autowired
    private ContactService contactService;
    @Override
    public void registration(RegisterRequest registerRequest) {
        if(userExist(registerRequest.getEmail())) throw new UserExistException(registerRequest.getEmail() + "already exist");
        ContactApp contactApp = map(registerRequest);
        contactAppRepository.save(contactApp);
    }
    private boolean userExist(String email) {
        ContactApp foundAccount = contactAppRepository.findByEmail(email);
        return foundAccount != null;
    }
    @Override
    public void login(LoginRequest loginRequest) {
        ContactApp foundAccount = contactAppRepository.findByEmail(loginRequest.getEmail());
        if(!userExist(loginRequest.getEmail())) throw  new InvalidDetailsException();
        if (!foundAccount.getPassword().equals(loginRequest.getPassword())) throw new InvalidDetailsException();

        foundAccount.setLocked(false);
        contactAppRepository.save(foundAccount);
    }
    @Override
    public void addContact(AddContactRequest addContact) {
        ContactApp contactApp = contactAppRepository.findByEmail(addContact.getEmail());
        contactService.addContact(contactApp.getId(), addContact.getName(), addContact.getPhoneNumber());
    }
    @Override
    public void deleteContact(DeleteContactRequest deleteContact){
        ContactApp contactApp = contactAppRepository.findByEmail(deleteContact.getEmail());
        contactService.deleteContact(contactApp.getId(), deleteContact.getName());
    }
    @Override
    public void editProfile(EditProfileRequest editProfileRequest) {
        ContactApp contactApp = contactAppRepository.findByEmail(editProfileRequest.getEmail());
        contactApp.setName(editProfileRequest.getName());
        contactAppRepository.save(contactApp);
    }
    @Override
    public void deleteProfile(String email) {
        ContactApp contactApp = contactAppRepository.findByEmail(email);
        contactAppRepository.delete(contactApp);
    }
    @Override
    public Contact findContact(FindContactRequest findContactRequest) {
        ContactApp contactApp = contactAppRepository.findByEmail(findContactRequest.getEmail());
        return contactService.findContact(contactApp.getId(), findContactRequest.getName());
    }
    @Override
    public List<Contact> findAllContact(String email) {
        ContactApp contactApp = contactAppRepository.findByEmail(email);
        return contactService.findAllContactBelongingTo(contactApp.getId());
    }
}
