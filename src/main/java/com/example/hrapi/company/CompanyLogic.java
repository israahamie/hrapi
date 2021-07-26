package com.example.hrapi.company;

import com.example.hrapi.address.Address;
import com.example.hrapi.address.AddressMapper;
import com.example.hrapi.company.response.CompanyResponse;
import com.example.hrapi.shared.exception.AddressNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * This class implements the logic for creating
 * a response body CompanyResponse which is used to
 * validate the fields to be inserted then enter
 * a Company into the database and returns the response
 * containing the status code and insertion
 */
@Service
@AllArgsConstructor
@Log4j2
public class CompanyLogic {
    private final CompanyMapper companyMapper;

    private final AddressMapper addressMapper;

    public CompanyResponse addCompany(
            String name,
            long addressId
    ) {
        log.info("Invoke adding new Company: name: {}", name);
        CompanyResponse result = new CompanyResponse();
        /*
        Validate that the address id exists and correct.
         */
        Address address = addressMapper.findAddressById(addressId);
        /*
        Handle if address is not valid.
         */
        if (address == null) {
            throw new AddressNotFoundException(addressId);
        }
        /*
        Filling Database object
         */
        Company company = new Company();
        company.setName(name);
        company.setAddress(address);
        /*
        Insert the new Company in database.
         */
        long id = companyMapper.insertCompany(company);
        /*
        update inserted id in the company object
         */
        company.setId(id);
        /*
        update return result
         */
        result.setCompany(company);
        /*
        Returning result
         */
        return result;
    }
}
