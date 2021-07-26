package com.example.hrapi.employee.response;

import com.example.hrapi.employee.Employee;
import com.example.hrapi.shared.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class implements a response from the server
 * containing the Employee requested by the client
 * and the status code of the request
 */

@Getter
@Setter
@ToString
public class EmployeeResponse extends BaseResponse {
    private Employee employee;
}
