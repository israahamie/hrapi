package com.example.hrapi.jobposition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class is a runtime exception which occurs if an jobPositionId
 * is not found in the job_position table in the database as a primary
 * key in the id column
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class PositionNotFoundException extends RuntimeException {
    private long jobPositionId;
}
