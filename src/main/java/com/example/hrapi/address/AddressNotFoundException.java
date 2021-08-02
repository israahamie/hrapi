package com.example.hrapi.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class is a runtime exception which occurs if an addressId
 * is not found in the address table in the database as a primary
 * key in the id column
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class AddressNotFoundException extends RuntimeException {
    private long addressId;
}
