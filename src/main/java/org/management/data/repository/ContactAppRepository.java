package org.management.data.repository;

import org.management.data.model.Contact;
import org.management.data.model.ContactApp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactAppRepository extends MongoRepository<ContactApp,String> {

    ContactApp findByEmail(String email);

}
