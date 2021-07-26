package com.example.hrapi.employeedepartment;

import com.example.hrapi.department.Department;
import com.example.hrapi.employee.Employee;
import com.example.hrapi.jobposition.JobPosition;
import lombok.Data;

/**
 * The Employee_Department class represents a model
 * of an employee belonging to a specific department and
 * working at a specific job position and employee_department
 * table in the hr database.
 *
 * @author Israa Hamieh
 */
@Data
public class EmployeeDepartment {
    /**
     * These fields represent the unique identification keys in
     * the employee, department, and address table. which illustrates
     * where each employee works
     */
    private Employee employee;
    private Department department;
    private JobPosition position;


}
