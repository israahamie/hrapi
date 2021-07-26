package com.example.hrapi.employee;

import com.example.hrapi.employee.request.NewEmployeeRequest;
import com.example.hrapi.employee.response.EmployeeResponse;
import com.example.hrapi.employee.response.EmployeesResponse;
import com.example.hrapi.shared.ResponseBody;
import com.example.hrapi.shared.exception.AddressNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The EmployeeController class links java method definitions
 * to their equivalent SQL statements/queries present in the
 * corresponding EmployeeMapper interface.
 * <p>
 * These methods read and write employee rows from and into
 * the employee table of the database.
 * <p>
 * This enables the communication with the hr database via the
 * web's http methods.
 *
 * @author Israa Hamieh
 */

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
@Log4j2
public class EmployeeController {

    private final EmployeeMapper employeeMapper;
    private final EmployeeLogic employeeLogic;

    /**
     * method gets the employee by matching it to its id
     *
     * @param id the employee row's unique identifying id
     * @return an Employee object
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<EmployeesResponse>> getEmployee(@PathVariable Long id) {
        log.info("Invoked getEmployee method, id: {}", id);
        EmployeesResponse response = new EmployeesResponse();
        response.getEmployees().add(employeeMapper.findEmployeeById(id));
        log.info("Return response: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method gets the employee by matching it to its id
     *
     * @param phoneNumber the employee row's unique contact number
     * @return an Employee object
     */
    @GetMapping("/number")
    public ResponseEntity<ResponseBody<EmployeesResponse>> getEmployeeByNumber(@RequestParam String phoneNumber) {
        log.info("Invoked getEmployeeByNumber method, number: {}", phoneNumber);
        EmployeesResponse response = new EmployeesResponse();
        response.getEmployees().add(employeeMapper.findEmployeeByNumber(phoneNumber));
        log.info("Return response: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method gets the employee by matching them to their first name
     *
     * @param name the employee row's first_name field which is
     *             the first name
     * @return a list of employee objects since
     * multiple employees may share the same names
     */
    @GetMapping("/name")
    public ResponseEntity<ResponseBody<EmployeesResponse>> getEmployeeByName(@RequestParam String name) {
        log.info("Invoked getEmployeeByName method, first name: {}", name);
        EmployeesResponse response = new EmployeesResponse();
        response.setEmployees(employeeMapper.findEmployeeByName(name));
        log.info("Return response: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method gets the employee by matching them to their last name
     *
     * @param surname the employee row's last_name field which is
     *                the last name
     * @return a list of employee objects since
     * multiple employees may share the same surnames
     */
    @GetMapping("/surname")
    public ResponseEntity<ResponseBody<EmployeesResponse>> getEmployeeBySurname(@RequestParam String surname) {
        log.info("Invoked getEmployeeBySurname method, last name: {}", surname);
        EmployeesResponse response = new EmployeesResponse();
        response.setEmployees(employeeMapper.findEmployeeBySurname(surname));
        log.info("Return response: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method gets the employee by matching their address to an address
     *
     * @param address_id the employee row's address_id field which is
     *                   a reference to their address
     * @return a list of employee objects since
     * multiple employees may share an address
     */
    @GetMapping("/address-id")
    public ResponseEntity<ResponseBody<EmployeesResponse>> getEmployeeByAddress(@RequestParam Long address_id) {
        log.info("Invoked getEmployeeByAddress method, address id: {}", address_id);
        EmployeesResponse response = new EmployeesResponse();
        response.setEmployees(employeeMapper.findEmployeeByAddress(address_id));
        log.info("Return response: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method inserts a new employee into the employee table
     * must commit the insertion due to changing the database (adding a row)
     *
     * @param newEmployeeRequest fields of a new employee row
     * @return a ResponseEntity containing the fields of the
     * Employee inserted into the database and the
     * status code of this request
     * @throws AddressNotFoundException in case the foreign
     *                                  address key does not exist in the address table
     *                                  and is thus mot a valid reference to an address
     */
    @PostMapping
    public ResponseEntity<ResponseBody<EmployeeResponse>> addEmployee(@RequestBody NewEmployeeRequest newEmployeeRequest) {
        log.info("invoke addEmployee method, New Employee Request :{}", newEmployeeRequest);
        /*
        Inserting the new Employee in the database.
         */
        EmployeeResponse response = employeeLogic.addEmployee(
                newEmployeeRequest.getFirstName(),
                newEmployeeRequest.getLastName(),
                newEmployeeRequest.getPhoneNumber(),
                newEmployeeRequest.getAddressId());
        /*
        Returning response entity
         */
        log.info("Return EmployeeResponse: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));


    }
}
