package com.example.hrapi.address.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class implements a request containing the fields necessary to
 * create a new address and add it to the database
 */
@Getter
@Setter
@ToString
public class NewAddressRequest {
    private String country;
    private String city;
}
