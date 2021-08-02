package com.example.hrapi.department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class is a runtime exception which occurs if a departmentId
 * is not found in the department table in the database as a primary
 * key in the id column
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class DepartmentNotFoundException extends RuntimeException {
    private long departmentId;
}
