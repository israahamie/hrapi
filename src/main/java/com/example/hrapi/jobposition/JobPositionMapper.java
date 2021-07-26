package com.example.hrapi.jobposition;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * This interface defines methods' functionalities
 * in the context of SQL queries. It implements mybatis,
 * allowing dynamic SQL statements within the java program.
 *
 * @author Israa Hamieh
 */
@Mapper
public interface JobPositionMapper {

    /**
     * This method is mapped to an sql select query which chooses
     * a job position row  from the job_position table in the db
     * by its id
     *
     * @param id the primary key of the job_position table
     * @return JobPosition object
     */
    @Select("SELECT id, title FROM job_position WHERE id = #{id}")
    JobPosition findJobPositionById(Long id);

    /**
     * This method is mapped to an sql select query which chooses
     * a job position row  from the job_position table in the db
     * by its title
     *
     * @param title the value of the title column in the
     *              job_position table
     * @return JobPosition object
     */
    @Select("SELECT id, title FROM job_position WHERE title = #{title}")
    JobPosition findJobPositionByTitle(String title);

    /**
     * This method is mapped to an sql select query which inserts
     * a new row  from the job_position table and returns its id
     * to be used for identifying and accessing the new row in the future
     *
     * @param jobPosition JobPosition Object
     * @return the generated integer id of the ne row
     */
    @Select("INSERT INTO job_position(title) VALUES(#{title}) RETURNING id;")
    @Options(flushCache = Options.FlushCachePolicy.TRUE)
    int insertPosition(JobPosition jobPosition);


}
