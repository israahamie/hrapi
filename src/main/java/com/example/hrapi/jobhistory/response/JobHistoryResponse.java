package com.example.hrapi.jobhistory.response;

import com.example.hrapi.jobhistory.JobHistory;
import com.example.hrapi.shared.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class implements a response from the server
 * containing the JobHistory requested by the client
 * and the status code of the request
 */

@Getter
@Setter
@ToString
public class JobHistoryResponse extends BaseResponse {
    private JobHistory history;

}
