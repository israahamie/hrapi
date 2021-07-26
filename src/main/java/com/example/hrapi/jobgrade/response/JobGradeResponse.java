package com.example.hrapi.jobgrade.response;

/**
 * This class implements a response from the server
 * containing the JobGrade requested by the client
 * and the status code of the request
 */

import com.example.hrapi.jobgrade.JobGrade;
import com.example.hrapi.shared.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JobGradeResponse extends BaseResponse {

    private JobGrade jobGrade;

}
