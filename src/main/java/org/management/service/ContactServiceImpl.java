package org.management.service;

import org.management.data.model.Contact;
import org.management.data.repository.ContactRepository;
import org.management.exceptions.NameAlreadyExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void addContact(String id, String name, String phoneNumber ) {
        Contact contact = new Contact();
        Contact contact1 = findContact(id,name);
        if(contact1 != null)throw new NameAlreadyExist();
        contact.setUserId(id);
        contact.setName(name);
        contact.setPhoneNumber(phoneNumber);
        contactRepository.save(contact);
    }

    @Override
    public void deleteContact(String id, String name) {
        List<Contact> contact = findAllContactBelongingTo(id);
        for (Contact contact1 : contact) {
            if (contact1.getName().equals(name)) {
                contactRepository.delete(contact1);
            }
        }
    }

    @Override
    public List<Contact> findAllContactBelongingTo(String id) {
        List<Contact> contacts = new ArrayList<>();
        for (Contact contact : contactRepository.findAll()) {
            if (contact.getUserId().equals(id)) {
                contacts.add(contact);
            }
        }
        return contacts;
    }

    @Override
    public Contact findContact(String id, String name) {
        List<Contact> contact = findAllContactBelongingTo(id);
        for (Contact contact1 : contact) {
            if (contact1.getName().equals(name)) {
                return contact1;
            }
        }
        return null;
    }


    private boolean nameExist(String id, String name) {
        List<Contact> contact = findAllContactBelongingTo(id);
        for (Contact contact1 : contact){
            if (contact1.getName().equals(name)){
                return true;
            }
        }
        return false;
    }


}

