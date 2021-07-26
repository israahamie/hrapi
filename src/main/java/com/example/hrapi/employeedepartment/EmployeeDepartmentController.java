package com.example.hrapi.employeedepartment;

import com.example.hrapi.employeedepartment.request.NewEmployeeDepartmentRequest;
import com.example.hrapi.employeedepartment.response.EmployeeDepartmentResponse;
import com.example.hrapi.shared.ResponseBody;
import com.example.hrapi.shared.exception.DepartmentNotFoundException;
import com.example.hrapi.shared.exception.EmployeeNotFoundException;
import com.example.hrapi.shared.exception.PositionNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The EmployeeDepartmentController class links java method definitions
 * to their equivalent SQL statements/queries present in the
 * corresponding EmployeeDepartmentMapper interface.
 * <p>
 * These methods can both read employee department rows from
 * employee_department the database;
 * <p>
 * This enables the communication with the hr database via the
 * web's http methods.
 *
 * @author Israa Hamieh
 */
@RestController
@RequestMapping("/employee-departments")
@AllArgsConstructor
@Log4j2
public class EmployeeDepartmentController {
    private final EmployeeDepartmentMapper employeeDepartmentMapper;
    private final EmployeeDepartmentLogic employeeDepartmentLogic;

    /**
     * method gets the employee_department relationship by employee
     * must commit the insertion due to changing the database (adding a row)
     *
     * @param employee_id the number id of the employee
     * @return Employee_Department object representing
     * the position and department of an employee
     */
    @GetMapping("/employee")
    public ResponseEntity<ResponseBody<EmployeeDepartmentResponse>> getEmployeeDepartment(@RequestParam Long employee_id) {
        log.info("Invoked getEmployeeDepartment method, employee id: {}", employee_id);
        EmployeeDepartmentResponse response = new EmployeeDepartmentResponse();
        response.setEmployeeDepartment(employeeDepartmentMapper.findEmployeeDepartmentByEmployee(employee_id));
        log.info("Return response: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method gets the employee_department relationship by employee
     * must commit the insertion due to changing the database (adding a row)
     *
     * @param newEmployeeDepartmentRequest Employee Department object
     * @return a ResponseEntity containing the fields of the EmployeeDepartment
     * inserted into the database and the status code of this request
     * @throws EmployeeNotFoundException   in case the foreign
     *                                     employee key does not exist in the employee table
     *                                     and is thus not a valid reference to an employee
     * @throws DepartmentNotFoundException in case the foreign
     *                                     department key does not exist in the department table
     *                                     and is thus not a valid reference to an department
     * @throws PositionNotFoundException   in case the foreign
     *                                     job_position key does not exist in the job_key table
     *                                     as a primary key and is thus not a valid key
     */
    @PostMapping()
    public ResponseEntity<ResponseBody<EmployeeDepartmentResponse>> addEmployeeDepartment
    (@RequestBody NewEmployeeDepartmentRequest newEmployeeDepartmentRequest) {

        log.info("invoke addEmployeeDepartment method, New EmployeeDepartment Request :{}", newEmployeeDepartmentRequest);
        /*
        Inserting the new EmployeeDepartment in the database.
         */
        EmployeeDepartmentResponse response = employeeDepartmentLogic.addEmployeeDepartment(
                newEmployeeDepartmentRequest.getEmployeeId(),
                newEmployeeDepartmentRequest.getDepartmentId(),
                newEmployeeDepartmentRequest.getPositionId()
        );
        /*
        Returning response entity
         */
        log.info("Return EmployeeDepartmentResponse: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }
}
