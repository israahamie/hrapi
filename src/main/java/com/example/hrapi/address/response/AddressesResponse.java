package com.example.hrapi.address.response;

import com.example.hrapi.address.Address;
import com.example.hrapi.shared.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * This class implements a response from the server
 * containing an Address List requested by the client
 * (in case of multiple returns from a request)
 * and the status code of the request
 */
@Getter
@Setter
@ToString
public class AddressesResponse extends BaseResponse {
    private List<Address> addresses;
}
