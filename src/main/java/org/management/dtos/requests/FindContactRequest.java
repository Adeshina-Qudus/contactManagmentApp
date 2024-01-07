package org.management.dtos.requests;

import lombok.Data;

@Data
public class FindContactRequest {
    private String name;
    private String email;
}
