package com.example.hrapi.employee;

import com.example.hrapi.address.Address;
import lombok.Data;

/**
 * The Employee class represents a model of a real world employee
 * and the employee table in the hr database.
 *
 * @author Israa Hamieh
 */
@Data
@SuppressWarnings("unused")
public class Employee {
    /**
     * This field represents the unique primary key of an employee entry
     */
    private Long id;
    /**
     * These fields all represent information about the employee,
     * including a reference to a valid address
     */
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Address address;


}