package com.example.hrapi.employeedepartment.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class implements a request the client can send
 * containing the fields necessary to create a new
 * EmployeeDepartment and add it to the database
 */
@Getter
@Setter
@ToString
public class NewEmployeeDepartmentRequest {
    private Long employeeId;
    private Long departmentId;
    private Long positionId;
}
