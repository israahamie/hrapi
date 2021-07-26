package com.example.hrapi.jobgrade.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class implements a request the client can send
 * containing the fields necessary to create a new
 * JobGrade and add it to the database
 */

@Getter
@Setter
@ToString
public class NewJobGradeRequest {
    private Long employeeId;
    private Long departmentId;
    private Long positionId;
    private short grade;
}
