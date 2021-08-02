package com.example.hrapi.department;

import com.example.hrapi.department.request.NewDepartmentRequest;
import com.example.hrapi.department.response.DepartmentResponse;
import com.example.hrapi.shared.ResponseBody;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * DepartmentController class defines methods that can access and insert
 * departments from and into the department table of the database.This
 * class provides the functionality as http GET and POST methods and
 * implements DepartmentMapper interface, which defines the SQL definitions.
 */
@RestController
@RequestMapping("/department")
@AllArgsConstructor
@Log4j2
public class DepartmentController {
    private final DepartmentMapper departmentMapper;
    private final DepartmentLogic departmentLogic;

    /**
     * method gets the department by matching it to its id
     *
     * @param id the department entry's unique identifying id
     * @return a Department object
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<DepartmentResponse>> getDepartment(@PathVariable Long id) {
        log.info("Invoke getDepartment Method, id: {}", id);
        DepartmentResponse response = new DepartmentResponse();
        response.setDepartment(departmentMapper.findDepartmentById(id));
        log.info("Return Response: {}", response.toString());
        return ResponseEntity.ok(ResponseBody.success(response));

    }

    /**
     * method gets the department by matching it to its name
     *
     * @param name the department name
     * @return a Department object
     */
    @GetMapping("/name")
    public ResponseEntity<ResponseBody<DepartmentResponse>> getDepartmentByName(@RequestParam String name) {
        log.info("Invoke getDepartmentByName method, name: {}", name);
        DepartmentResponse response = new DepartmentResponse();
        response.setDepartment(departmentMapper.findDepartmentByName(name));
        log.info("Return response: {}", response.toString());
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method inserts a new department into the department table (adding a row)
     * in the database
     *
     * @param newDepartmentRequest a request containing the fields needed for creating
     *                             a new department and inserting it into the table
     * @return a ResponseEntity containing the fields of the Department inserted into the database and the
     * status code of this request
     */
    @PostMapping("/add")
    public ResponseEntity<ResponseBody<DepartmentResponse>> addDepartment(@RequestBody NewDepartmentRequest newDepartmentRequest) {
        log.info("invoke addDepartment method, New Department Request :{}", newDepartmentRequest);
        /*
        Inserting the new Department in the database.
         */
        DepartmentResponse response = departmentLogic.addDepartment(
                newDepartmentRequest.getName());
        /*
        Returning response entity
         */
        log.info("Return DepartmentResponse: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }
}