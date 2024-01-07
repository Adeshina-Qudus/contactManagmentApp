package org.management.dtos.requests;

import lombok.Data;

@Data
public class AddContactRequest {
    private String name;
    private String phoneNumber;
    private String email;
}
