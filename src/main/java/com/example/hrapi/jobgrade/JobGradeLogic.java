package com.example.hrapi.jobgrade;

import com.example.hrapi.department.Department;
import com.example.hrapi.department.DepartmentMapper;
import com.example.hrapi.department.DepartmentNotFoundException;
import com.example.hrapi.employee.Employee;
import com.example.hrapi.employee.EmployeeMapper;
import com.example.hrapi.employee.EmployeeNotFoundException;
import com.example.hrapi.jobgrade.response.JobGradeResponse;
import com.example.hrapi.jobposition.JobPosition;
import com.example.hrapi.jobposition.JobPositionMapper;
import com.example.hrapi.jobposition.PositionNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * This class implements the logic for creating
 * a response body JobGradeResponse which is used to
 * validate the fields to be inserted then enter
 * a JobGrade into the database and returns the response
 * containing the status code and insertion
 */
@Service
@AllArgsConstructor
@Log4j2
public class JobGradeLogic {
    private final JobGradeMapper jobGradeMapper;

    private final EmployeeMapper employeeMapper;
    private final DepartmentMapper departmentMapper;
    private final JobPositionMapper jobPositionMapper;

    public JobGradeResponse addJobGrade(

            long employeeId,
            long departmentId,
            long positionId,
            short grade
    ) throws GradeException {
        log.info("Invoke adding new JobGrade: grade: {}", grade);
        JobGradeResponse result = new JobGradeResponse();
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
        JobGrade jobGrade = new JobGrade();
        jobGrade.setGrade(grade);
        jobGrade.setEmployee(employee);
        jobGrade.setDepartment(department);
        jobGrade.setPosition(position);
        /*
        Insert the new JobGrade in database.
         */
        long id = jobGradeMapper.insertGrade(jobGrade);
        /*
        update inserted id in the JobGrade object
         */
        jobGrade.setId(id);
        /*
        update return result
         */
        result.setJobGrade(jobGrade);
        /*
        Returning result
         */
        return result;
    }
}
