package org.management.service;

import org.management.data.model.Contact;
import org.management.dtos.requests.*;

import java.util.List;

public interface ContactAppService {

    void registration(RegisterRequest registerRequest);
    void login(LoginRequest loginRequest);
    void addContact(AddContactRequest addContactRequest);
    void deleteContact(DeleteContactRequest deleteContact);
    void editProfile(EditProfileRequest editProfileRequest);
    void deleteProfile(String email);
    Contact findContact(FindContactRequest findContactRequest);
    List<Contact> findAllContact(String email);

}
