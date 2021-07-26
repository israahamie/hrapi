package com.example.hrapi.department;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * DepartmentMapper defines the SQL functionality
 * of the methods in DepartmentController.
 * These methods allow communication with the hr database.
 *
 * @author Israa Hamieh
 */
@Mapper
public interface DepartmentMapper {
    /**
     * This method is mapped to an sql select query which chooses
     * a department from the db by its unique id
     *
     * @param id the identifying number in the  id column
     * @return Department object
     */
    @Select("SELECT id, name FROM department WHERE id = #{id}")
    Department findDepartmentById(Long id);

    /**
     * This method is mapped to an sql select query which chooses
     * an address from the db by its country
     *
     * @param name the department name in the name column of
     *             the department table
     * @return Department object
     */
    @Select("SELECT id, name FROM department WHERE name = #{name}")
    Department findDepartmentByName(String name);

    /**
     * This method is mapped to an sql select query which inserts a new
     * department into the department table and returns its id
     *
     * @param department Department Object
     * @return an integer which is the generated
     * id of the new inserted department
     */
    @Select("INSERT INTO department(name) VALUES(#{name}) RETURNING id;")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int insertDepartment(Department department);
}
