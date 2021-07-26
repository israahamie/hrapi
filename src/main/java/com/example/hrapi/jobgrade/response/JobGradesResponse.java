package com.example.hrapi.jobgrade.response;

import com.example.hrapi.jobgrade.JobGrade;
import com.example.hrapi.shared.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * This class implements a response from the server
 * containing a list ofJobGrades requested by the client
 * in case of multiple returns in response to the request
 * and the status code of the requests
 */

@Getter
@Setter
@ToString
public class JobGradesResponse extends BaseResponse {
    private List<JobGrade> jobGrades;
}
