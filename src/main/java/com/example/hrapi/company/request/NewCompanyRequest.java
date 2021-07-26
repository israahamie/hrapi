package com.example.hrapi.company.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class implements a request containing the fields necessary to
 * create a new company and add it to the database
 */

@Getter
@Setter
@ToString
public class NewCompanyRequest {
    private String name;
    private long addressId;

}
