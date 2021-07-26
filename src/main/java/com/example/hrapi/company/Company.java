package com.example.hrapi.company;

import com.example.hrapi.address.Address;
import lombok.Data;

/**
 * The Company class represents the company table and its columns
 * in the hr database.
 *
 * @author Israa Hamieh
 */
@Data
public class Company {
    /**
     * This field represents the unique key of an address entry
     */
    private Long id;
    /**
     * This field represents the company name which must be specified and unique
     */
    private String name;
    /**
     * This field must match an id of an address in the address table (address object in java)
     */
    private Address address;

}
