package com.example.hrapi.jobposition.response;

import com.example.hrapi.jobposition.JobPosition;
import com.example.hrapi.shared.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class implements a response from the server
 * containing the Jobposition requested by the client
 * and the status code of the request
 */
@Getter
@Setter
@ToString
public class JobPositionResponse extends BaseResponse {
    private JobPosition position;
}
