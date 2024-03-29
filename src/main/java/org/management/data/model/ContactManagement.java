package org.management.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ContactManagement {
    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String address;
    private boolean isLocked = true;
}
