package com.example.hrapi.address.response;

import com.example.hrapi.address.Address;
import com.example.hrapi.shared.BaseResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class implements a response from the server
 * containing the Address requested by the client
 * and the status code of the request
 */
@Getter
@Setter
@ToString
public class AddressResponse extends BaseResponse {

    private Address address;

}
