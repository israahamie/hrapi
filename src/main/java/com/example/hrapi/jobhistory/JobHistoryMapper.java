package com.example.hrapi.jobhistory;

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
public interface JobHistoryMapper {

    /**
     * This method is mapped to an sql select query which chooses
     * a row from the job_history table by its employee id foreign key
     *
     * @param employee_id the foreign key in job_history table
     * @return JobHistory list since an employee can have
     * multiple preceding jobs
     */
    @Select("SELECT fk_employee_id, fk_position_id, fk_company_id, from_date, to_date, is_current FROM job_history WHERE fk_employee_id = #{employee.id}")
    @Results(id = "historyResultMap", value = {
            @Result(property = "fromDate", column = "from_date"),
            @Result(property = "toDate", column = "to_date"),
            @Result(property = "isCurrent", column = "is_current"),
            @Result(property = "employee", column = "fk_employee_id", one =
            @One(select = "com.example.hrapi.employee.EmployeeMapper.findEmployeeById")),
            @Result(property = "position", column = "fk_position_id", one =
            @One(select = "com.example.hrapi.jobposition.JobPositionMapper.findJobPositionById")),
            @Result(property = "company", column = "fk_company_id", one =
            @One(select = "com.example.hrapi.company.CompanyMapper.findCompanyById"))
    })
    List<JobHistory> findJobHistoryByEmployee(Long employee_id);

    /**
     * This method is mapped to an sql select query which inserts
     * a new job history entry into job_history table and returns its
     * id for future access
     *
     * @param history JobHistory object, the fields of which will be
     *                inserted into the corresponding columns of the
     *                job_history table
     * @return the generated integer id of the new row
     */
    @Select("INSERT INTO job_history(fk_employee_id, fk_position_id,fk_company_id,from_date,to_date,is_current) " +
            "VALUES(#{employee.id},#{position.id},#{company.id},#{fromDate},{toDate},{isCurrent}) RETURNING id;")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int insertHistory(JobHistory history);
}
