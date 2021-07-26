package com.example.hrapi.jobposition.response;

import com.example.hrapi.jobposition.JobPosition;
import com.example.hrapi.shared.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * This class implements a response from the server
 * containing a list of JobPositions requested by the client
 * in case of multiple returns in response to the request
 * and the status code of the request
 */

@Getter
@Setter
@ToString
public class JobPositionsResponse extends BaseResponse {
    private List<JobPosition> jobPositions;
}
