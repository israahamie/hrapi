package com.example.hrapi.address;

import lombok.Data;

/**
 * The Address class represents a model of a real world
 * address and the address table in the hr database.
 *
 * @author Israa Hamieh
 */
@Data
public class Address {
    /**
     * This field represents the unique key of an address entry
     */
    private Long id;
    /**
     * An address includes a city and its country
     */
    private String country;
    private String city;

}
