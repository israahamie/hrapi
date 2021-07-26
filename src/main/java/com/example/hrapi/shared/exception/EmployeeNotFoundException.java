package com.example.hrapi.shared.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class is a runtime exception which occurs if an employeeId
 * is not found in the employee table in the database as a primary
 * key in the id column
 */

@Getter
@Setter
@AllArgsConstructor
@ToString
public class EmployeeNotFoundException extends RuntimeException {
    private long employeeId;
}
