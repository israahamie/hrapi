package com.example.hrapi.jobgrade;

import com.example.hrapi.department.Department;
import com.example.hrapi.employee.Employee;
import com.example.hrapi.jobposition.JobPosition;
import lombok.Data;

/**
 * The JobGrade class represents a model of a real world
 * job evaluation and the job_grade table in the hr database.
 *
 * @author Israa Hamieh
 */
@Data
public class JobGrade {
    /**
     * This field represents the unique key of a row in the
     * job_grade table
     */

    private Long id;
    /**
     * These field represents which employees work at what
     * positions in certain departments
     */

    private Employee employee;
    private Department department;
    private JobPosition position;
    /**
     * This field represents the grade given between 1 and 10
     * to the employee
     */

    private short grade;
}
