package com.example.hrapi.employeedepartment;

import org.apache.ibatis.annotations.*;

/**
 * This interface defines methods' functionalities
 * in the context of SQL queries. It implements mybatis,
 * allowing dynamic SQL statements within the java program.
 *
 * @author Israa Hamieh
 */

@Mapper
public interface EmployeeDepartmentMapper {
    /**
     * This method is mapped to an sql select query which chooses
     * a row from employee_department table in the db by the employee
     *
     * @param employee_id the id of an employee row in the
     *                    employee table which represents an employee
     * @return Employee_Department list
     */
    @Select("SELECT fk_employee_id, fk_department_id , fk_position_id FROM employee_department WHERE fk_employee_id  = #{employee.id}")
    @Results({
            @Result(property = "employee", column = "fk_employee_id", one =
            @One(select = "com.example.hrapi.employee.EmployeeMapper.findEmployeeById")),
            @Result(property = "department", column = "fk_department_id", one =
            @One(select = "com.example.hrapi.department.DepartmentMapper.findDepartmentById")),
            @Result(property = "position", column = "fk_position_id", one =
            @One(select = "com.example.hrapi.jobposition.JobPositionMapper.findJobPositionById")),
    })
    EmployeeDepartment findEmployeeDepartmentByEmployee(Long employee_id);


    /**
     * This method is mapped to an sql select query which adds
     * a row to employee_department table in the database and returns
     * its id to be able to once again access it in the future
     *
     * @param employeeDepartment EmployeeDepartment Object whose
     *                           fields are to be inserted into the
     *                           employee_department table
     * @return the generated id of the new employee_department row
     */

    @Select("INSERT INTO employee_department(fk_employee_id, fk_department_id , fk_position_id) " +
            "VALUES(#{employee.id}, #{department.id}, #{position.id});")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    void insertEmployeeDepartment(EmployeeDepartment employeeDepartment);

}
