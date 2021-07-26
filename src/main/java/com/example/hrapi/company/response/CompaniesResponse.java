package com.example.hrapi.company.response;

import com.example.hrapi.company.Company;
import com.example.hrapi.shared.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * This class implements a response from the server
 * containing a list of Company Objects requested by the client
 * (when there are multiple returns from a request)
 * and the status code of the request
 */
@Getter
@Setter
@ToString
public class CompaniesResponse extends BaseResponse {
    private List<Company> companies;
}
