package org.management.dtos.requests;

import lombok.Data;

@Data
public class EditProfileRequest {
    private String name;
    private String email;
}
