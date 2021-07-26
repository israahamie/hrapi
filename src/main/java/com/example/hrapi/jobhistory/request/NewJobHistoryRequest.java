package com.example.hrapi.jobhistory.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * This class implements a request the client can send
 * containing the fields necessary to create a new
 * JobHistory and add it to the database
 */
@Getter
@Setter
@ToString
public class NewJobHistoryRequest {
    private Long employeeId;
    private Long companyId;
    private Long positionId;
    private Date fromDate;
    private Date toDate;
    private boolean isCurrent;
}
