package com.example.hrapi.department;

import com.example.hrapi.department.response.DepartmentResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * This class implements the logic for creating
 * a response body DepartmentResponse which is used to
 * validate the fields to be inserted then enter
 * a Department into the database and returns the response
 * containing the status code and insertion
 */
@Service
@AllArgsConstructor
@Log4j2
public class DepartmentLogic {

    private final DepartmentMapper departmentMapper;

    public DepartmentResponse addDepartment(
            String name
    ) {
        log.info("Invoke adding new Department: name: {}", name);
        DepartmentResponse result = new DepartmentResponse();

        /*
        Filling Database object
         */
        Department department = new Department();
        department.setName(name);
        /*
        Insert the new Department in database.
         */
        long id = departmentMapper.insertDepartment(department);
        /*
        update inserted id in the department object
         */
        department.setId(id);
        /*
        update return result
         */
        result.setDepartment(department);
        /*
        Returning result
         */
        return result;
    }
}
