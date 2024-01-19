package org.management.dtos.responses;

import lombok.Data;

@Data
public class FindAllContactResponse {
    private Object allContact;
    private boolean isSuccessful;
}
