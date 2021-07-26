package com.example.hrapi.employeedepartment.response;

import com.example.hrapi.employeedepartment.EmployeeDepartment;
import com.example.hrapi.shared.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class implements a response from the server
 * containing the EmployeeDepartment requested by the client
 * and the status code of the request
 */

@Getter
@Setter
@ToString
public class EmployeeDepartmentResponse extends BaseResponse {
    private EmployeeDepartment employeeDepartment;
}
