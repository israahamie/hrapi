package com.example.hrapi.shared;

import com.example.hrapi.address.AddressExceptionHandler;
import com.example.hrapi.address.AddressNotFoundException;
import com.example.hrapi.company.CompanyExceptionHandler;
import com.example.hrapi.company.CompanyNotFoundException;
import com.example.hrapi.department.DepartmentExceptionHandler;
import com.example.hrapi.department.DepartmentNotFoundException;
import com.example.hrapi.employee.EmployeeExceptionHandler;
import com.example.hrapi.employee.EmployeeNotFoundException;
import com.example.hrapi.jobposition.PositionExceptionHandler;
import com.example.hrapi.jobposition.PositionNotFoundException;

/**This class stores the status codes in case of bad requests made by the client
 * The program recognizes the exception type based on these status codes*/

public final class StatusCodesConstants {

    //private constructor so that this class cannot be instantiated
    private StatusCodesConstants() {
    }
    /**The invalid address code is used in the response entity in case the client
     * tries to create a new entry with a foreign key that does not exist as a
     * primary key in the address table. This means that the client attempted to
     * reference an address with an invalid key
     * @see AddressNotFoundException
     * @see AddressExceptionHandler
     */

    public static final String invalidAddressCode = "3020";


    /**The invalid company code is used in the response entity in case the client
     * tries to create a new entry with a foreign key that does not exist as a
     * primary key in the company table. This means that the client attempted to
     * reference a company with an invalid key
     * @see CompanyNotFoundException
     * @see CompanyExceptionHandler
     */

    public static final String invalidCompanyCode = "3030";


    /**The invalid department code is used in the response entity in case the client
     * tries to create a new entry with a foreign key that does not exist as a
     * primary key in the department table. This means that the client attempted to
     * reference a department with an invalid key
     * @see DepartmentNotFoundException
     * @see DepartmentExceptionHandler
     */

    public static final String invalidDepartmentCode = "3040";


    /**The invalid employee code is used in the response entity in case the client
     * tries to create a new entry with a foreign key that does not exist as a
     * primary key in the employee table. This means that the client attempted to
     * reference an employee with an invalid key
     * @see EmployeeNotFoundException
     * @see EmployeeExceptionHandler
     */

    public static final String invalidEmployeeCode = "3050";




    /**The invalid position code is used in the response entity in case the client
     * tries to create a new entry with a foreign key that does not exist as a
     * primary key in the job_position table. This means that the client attempted to
     * reference a job position with an invalid key
     * @see PositionNotFoundException
     * @see PositionExceptionHandler
     */

    public static final String invalidPositionCode = "3060";


    /**The invalid grade code is used in the response entity in case the client
     * tries to create a new entry with a grade outside the range between 1 and 10
     * @see com.example.hrapi.jobgrade.GradeException
     */

    public static final String invalidGradeCode = "3070";
}
