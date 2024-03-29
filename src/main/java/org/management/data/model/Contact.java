package org.management.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

    @Document
    @Data
    public class  Contact {
        @Id
        private String id;
        private String name;
        private String phoneNumber;
        private String userId;

    }

