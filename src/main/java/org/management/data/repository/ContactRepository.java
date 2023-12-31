package org.management.data.repository;

import org.management.data.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface ContactRepository extends MongoRepository<Contact,String> {


}