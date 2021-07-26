package com.example.hrapi.employee.response;

import com.example.hrapi.employee.Employee;
import com.example.hrapi.shared.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

/**
 * This class implements a response from the server
 * containing a list of Employees requested by the client
 * (in case of multiple returns in response to the request)
 * and the status code of the request
 */

@Getter
@Setter
@ToString
public class EmployeesResponse extends BaseResponse {
    private List<Employee> employees;

    public EmployeesResponse() {
        employees = new LinkedList<>();
    }
}
