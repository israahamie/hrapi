package com.example.hrapi.department.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class implements a request the client can send
 * containing the fields necessary to create a new
 * department and add it to the database
 */

@Getter
@Setter
@ToString
public class NewDepartmentRequest {
    private String name;

}
