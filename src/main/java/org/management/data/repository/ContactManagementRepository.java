package org.management.data.repository;

import org.management.data.model.ContactManagement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactManagementRepository extends MongoRepository<ContactManagement,String> {

    ContactManagement findByEmail(String email);

}
