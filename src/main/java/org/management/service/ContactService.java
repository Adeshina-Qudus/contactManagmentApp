package org.management.service;

import org.management.data.model.Contact;

import java.util.List;

public interface ContactService {


    void addContact(String id, String name, String phoneNumber);
    void deleteContact(String id, String name);
    List<Contact> findAllContactBelongingTo(String id);
    Contact findContact(String id, String name);

}
