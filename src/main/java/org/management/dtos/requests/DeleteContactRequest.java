package org.management.dtos.requests;

import lombok.Data;

@Data
public class DeleteContactRequest {
    private String name;
    private String email;
}
