package com.example.hrapi.jobgrade;

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
public interface JobGradeMapper {
    /**
     * This method is mapped to an sql select query which chooses
     * a Job_grade row from the db by its id
     *
     * @param id the primary unique key identifying each row
     * @return JobGrade
     */
    @Select("SELECT id, fk_position_id, fk_department_id, fk_employee_id, grade FROM job_grade WHERE id = #{id}")
    @Results(id = "gradeResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "grade", column = "grade"),
            @Result(property = "position", column = "fk_position_id", one =
            @One(select = "com.example.hrapi.jobposition.JobPositionMapper.findJobPositionById")),
            @Result(property = "department", column = "fk_department_id", one =
            @One(select = "com.example.hrapi.department.DepartmentMapper.findDepartmentById")),
            @Result(property = "employee", column = "fk_employee_id", one =
            @One(select = "com.example.hrapi.employee.EmployeeMapper.findEmployeeById"))
    })
    JobGrade findJobGradeById(Long id);

    /**
     * This method is mapped to an sql select query which chooses
     * a Job_grade row from the db by its employee
     *
     * @param employee_id the primary unique key identifying each row
     *                    in the employee table
     * @return JobGrade list
     */
    @Select("SELECT id, fk_position_id, fk_department_id, fk_employee_id, grade FROM job_grade WHERE fk_employee_id = #{employee_id}")
    @ResultMap("gradeResultMap")
    List<JobGrade> findJobGradeByEmployee(Long employee_id);

    /**
     * This method is mapped to an sql select query which chooses
     * a Job_grade row from the db by the job position
     *
     * @param position_id the primary unique key identifying each row
     *                    in the job_position table
     * @return JobGrade list
     */
    @Select("SELECT id, fk_position_id, fk_department_id, fk_employee_id,grade FROM job_grade WHERE fk_position_id = #{position_id}")
    @ResultMap("gradeResultMap")
    List<JobGrade> findJobGradeByPosition(Long position_id);

    /**
     * This method is mapped to an sql select query which chooses
     * a Job_grade row from the db by the job department
     *
     * @param department_id the primary unique key identifying each row
     *                      in the department table
     * @return JobGrade list
     */
    @Select("SELECT id, fk_position_id, fk_department_id, fk_employee_id,grade FROM job_grade WHERE fk_department_id = #{department.id}")
    @ResultMap("gradeResultMap")
    List<JobGrade> findJobGradeByDepartment(Long department_id);

    /**
     * This method is mapped to an sql select query which chooses
     * a Job_grade row from the db by the grade
     *
     * @param grade the grade between 1 and 10 received by the employee
     * @return JobGrade list
     */
    @Select("SELECT id, fk_position_id, fk_department_id, fk_employee_id,grade FROM job_grade WHERE grade = #{grade}")
    @ResultMap("gradeResultMap")
    List<JobGrade> findJobGradeByGrade(Short grade);

    /**
     * This method is mapped to an sql select query which
     * enters a new job grade row into the job_grade table
     * and returns its id to be used for future accessing of the new row
     *
     * @param jobGrade JobGrade object
     * @return the generated integer id of the new job_grade row
     */
    @Select("INSERT INTO job_grade(fk_employee_id, fk_position_id,fk_department_id,grade) " +
            "VALUES(#{employee.id},#{position.id},#{department.id},#{grade}) RETURNING id;")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int insertGrade(JobGrade jobGrade) throws GradeException;
}
