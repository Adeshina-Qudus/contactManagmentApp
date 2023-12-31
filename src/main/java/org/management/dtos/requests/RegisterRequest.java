package org.management.dtos.requests;

import lombok.Data;

@Data
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String password;
}
