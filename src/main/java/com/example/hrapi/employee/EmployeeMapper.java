package com.example.hrapi.employee;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * This interface defines methods' functionalities
 * in the context of SQL queries. It implements mybatis,
 * allowing dynamic SQL statements within the java program.
 *
 * @author Israa Hamieh
 */
@Mapper
public interface EmployeeMapper {

    /**
     * This method is mapped to an sql select query which chooses
     * an employee from the db by its id
     *
     * @param id the unique primary key of the employee table
     *           which identifies each row
     * @return Employee object
     */
    @Select("SELECT id, first_name ,last_name , phone_number,fk_address_id FROM employee WHERE id = #{id}")
    @Results(id = "employeeResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "address", column = "fk_address_id", one =
            @One(select = "com.example.hrapi.address.AddressMapper.findAddressById"))
    })
    Employee findEmployeeById(Long id);

    /**
     * This method is mapped to an sql select query which chooses
     * an employee from the db by the phone number
     *
     * @param phoneNumber the unique contact number
     * @return Employee object
     */
    @Select("SELECT id,first_name,last_name , phone_number , fk_address_id FROM employee WHERE phone_number = #{phoneNumber}")
    @ResultMap("employeeResultMap")
    Employee findEmployeeByNumber(String phoneNumber);

    /**
     * This method is mapped to an sql select query which chooses
     * an employee from the db by its first name
     *
     * @param name the employee's first name
     * @return Employee list
     */
    @Select("SELECT id, first_name ,last_name , phone_number, fk_address_id FROM employee WHERE first_name = #{firstName}")
    @ResultMap("employeeResultMap")
    List<Employee> findEmployeeByName(String name);

    /**
     * This method is mapped to an sql select query which chooses
     * an employee from the db by its last name
     *
     * @param surname the last_name field in the employee table
     * @return Employee list
     */
    @Select("SELECT id, first_name ,last_name , phone_number, fk_address_id FROM employee WHERE last_name = #{lastName}")
    @ResultMap("employeeResultMap")
    List<Employee> findEmployeeBySurname(String surname);

    /**
     * This method is mapped to an sql select query which chooses
     * an employee from the db by the address
     *
     * @param address_id the address of the employee
     * @return Employee list
     */
    @Select("SELECT id, first_name ,last_name, phone_number , fk_address_id FROM employee WHERE fk_address_id = #{address.id}")
    @ResultMap("employeeResultMap")
    List<Employee> findEmployeeByAddress(Long address_id);


    /**
     * This method is mapped to an sql select query which adds a
     * new employee to the employee table and returns its id
     *
     * @param employee an Employee Object whose fields will
     *                 be inserted into the table
     * @return an integer which is the generated id of the
     * new Employee row
     */
    @Select("INSERT INTO employee(first_name,last_name,phone_number,fk_address_id) VALUES(#{firstName},#{lastName},#{phoneNumber},#{address.id}) RETURNING id;")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int insertEmployee(Employee employee);
}
