package com.example.hrapi.jobhistory.response;

import com.example.hrapi.jobhistory.JobHistory;
import com.example.hrapi.shared.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * This class implements a response from the server
 * containing a list of JobHistory requested by the client
 * (in case of multiple returns in response to the request)
 * and the status code of the request
 */

@Getter
@Setter
@ToString
public class JobHistoriesResponse extends BaseResponse {
    private List<JobHistory> jobHistories;
}
