package com.example.hrapi.employee.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class implements a request the client can send
 * containing the fields necessary to create a new
 * employee and add it to the database
 */

@Getter
@Setter
@ToString
public class NewEmployeeRequest {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private long addressId;

}
