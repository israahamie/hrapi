package com.example.hrapi.jobhistory;

import com.example.hrapi.company.Company;
import com.example.hrapi.employee.Employee;
import com.example.hrapi.jobposition.JobPosition;
import lombok.Data;

import java.util.Date;

/**
 * The JobHistory class represents the precedent jobs an employee had
 * and the job_history table in the hr database.
 *
 * @author Israa Hamieh
 */
@Data
@SuppressWarnings("unused")
public class JobHistory {
    /**
     * This field validates that an employee works
     * at only one place at a time
     */
    //private int index;

    /**
     * These fields show where employees work in companies
     */

    private Employee employee;
    private Company company;
    private JobPosition position;
    /**
     * The fromDate and toDate Dates show the time frame of work
     */

    private Date fromDate;
    private Date toDate;
    /**
     * This field may be true or false depending on whether the
     * employee works at the job at present or not
     */
    private boolean isCurrent;

}
