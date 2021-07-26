package com.example.hrapi.address;

import com.example.hrapi.address.response.AddressResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * This class implements the logic for creating
 * a response body AddressResponse which inserts an Address into the database
 * and returns the inserted object
 */
@Service
@AllArgsConstructor
@Log4j2
public class AddressLogic {

    private final AddressMapper addressMapper;

    public AddressResponse addAddress(
            String country,
            String city
    ) {
        log.info("Invoke adding new Address: country: {}", country);
        AddressResponse result = new AddressResponse();

        /*
        Filling Database object
         */
        Address address = new Address();
        address.setCountry(country);
        address.setCity(city);
        /*
        Insert the new Address in database.
         */
        long id = addressMapper.insertAddress(address);
        /*
        update inserted id in the address object
         */
        address.setId(id);
        /*
        update return result
         */
        result.setAddress(address);
        /*
        Returning result
         */
        return result;
    }
}
