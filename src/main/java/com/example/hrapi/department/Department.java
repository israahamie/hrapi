package com.example.hrapi.department;

import lombok.Data;

/**
 * The Department class represents the department table and its columns
 * in the hr database.
 *
 * @author Israa Hamieh
 */
@Data
public class Department {
    /**
     * This field represents the unique key of a department entry
     */
    private Long id;
    /**
     * department name
     */
    private String name;


}
