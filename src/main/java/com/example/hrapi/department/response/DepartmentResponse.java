package com.example.hrapi.department.response;

import com.example.hrapi.department.Department;
import com.example.hrapi.shared.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class implements a response from the server
 * containing the Department requested by the client
 * and the status code of the request
 */

@Getter
@Setter
@ToString
public class DepartmentResponse extends BaseResponse {
    private Department department;
}
