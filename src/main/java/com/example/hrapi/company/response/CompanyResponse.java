package com.example.hrapi.company.response;

import com.example.hrapi.company.Company;
import com.example.hrapi.shared.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class implements a response from the server
 * containing the Company requested by the client
 * and the status code of the request
 */
@Getter
@Setter
@ToString
public class CompanyResponse extends BaseResponse {
    private Company company;

}
