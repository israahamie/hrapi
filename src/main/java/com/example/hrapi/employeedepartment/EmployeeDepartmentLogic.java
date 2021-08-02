package com.example.hrapi.employeedepartment;

import com.example.hrapi.department.Department;
import com.example.hrapi.department.DepartmentMapper;
import com.example.hrapi.department.DepartmentNotFoundException;
import com.example.hrapi.employee.Employee;
import com.example.hrapi.employee.EmployeeMapper;
import com.example.hrapi.employee.EmployeeNotFoundException;
import com.example.hrapi.employeedepartment.response.EmployeeDepartmentResponse;
import com.example.hrapi.jobposition.JobPosition;
import com.example.hrapi.jobposition.JobPositionMapper;
import com.example.hrapi.jobposition.PositionNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * This class implements the logic for creating
 * a response body EmployeeDepartmentResponse which is used to
 * validate the fields to be inserted then enter
 * an EmployeeDepartment into the database and returns the response
 * containing the status code and insertion
 */
@Service
@AllArgsConstructor
@Log4j2
public class EmployeeDepartmentLogic {
    private final EmployeeDepartmentMapper employeeDepartmentMapper;

    private final EmployeeMapper employeeMapper;
    private final DepartmentMapper departmentMapper;
    private final JobPositionMapper jobPositionMapper;

    public EmployeeDepartmentResponse addEmployeeDepartment(
            long employeeId,
            long departmentId,
            long positionId
    ) {
        log.info("Invoke adding new EmployeeDepartment: employee id: {}", employeeId);
        EmployeeDepartmentResponse result = new EmployeeDepartmentResponse();

        /*
        Validate that the employee id, department id, and position id exist and are correct.
         */

        Employee employee = employeeMapper.findEmployeeById(employeeId);
        Department department = departmentMapper.findDepartmentById(departmentId);
        JobPosition position = jobPositionMapper.findJobPositionById(positionId);

        /*
        Handle if address, department, or position is not valid.
         */
        if (employee == null) {
            throw new EmployeeNotFoundException(employeeId);
        }
        if (department == null) {
            throw new DepartmentNotFoundException(departmentId);
        }
        if (position == null) {
            throw new PositionNotFoundException(positionId);
        }

        /*
        Filling Database object
         */

        EmployeeDepartment employeeDepartment = new EmployeeDepartment();
        employeeDepartment.setEmployee(employee);
        employeeDepartment.setDepartment(department);
        employeeDepartment.setPosition(position);
        /*
        Insert the new EmployeeDepartment in database.
         */

        /*
        update return result
         */
        result.setEmployeeDepartment(employeeDepartment);
        /*
        Returning result
         */
        return result;
    }
}
