package com.example.hrapi.jobposition;

import lombok.Data;

/**
 * This class represents a model of a real world
 * occupation and the job_position table in the hr database.
 *
 * @author Israa Hamieh
 */
@Data
public class JobPosition {
    /**
     * This field represents the unique key of a row in the
     * job_position table
     */
    private Long id;
    /**
     * this is the position title that
     * the employee has
     */
    private String title;


}
