package com.example.hrapi.employee;


import com.example.hrapi.address.Address;
import com.example.hrapi.address.AddressMapper;
import com.example.hrapi.employee.response.EmployeeResponse;
import com.example.hrapi.shared.exception.AddressNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * This class implements the logic for creating
 * a response body EmployeeResponse which is used to
 * validate the fields to be inserted then enter
 * an Employee into the database and returns the response
 * containing the status code and insertion
 */
@Service
@AllArgsConstructor
@Log4j2
public class EmployeeLogic {

    private final EmployeeMapper employeeMapper;

    private final AddressMapper addressMapper;

    public EmployeeResponse addEmployee(
            String firstName,
            String lastName,
            String phoneNumber,
            long addressId
    ) {
        log.info("Invoke adding new Employee: firstName: {}", firstName);
        EmployeeResponse result = new EmployeeResponse();
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
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setPhoneNumber(phoneNumber);
        employee.setAddress(address);
        /*
        Insert the new Employee in database.
         */
        long id = employeeMapper.insertEmployee(employee);
        /*
        update inserted id in the employee object
         */
        employee.setId(id);
        /*
        update return result
         */
        result.setEmployee(employee);
        /*
        Returning result
         */
        return result;
    }
}
