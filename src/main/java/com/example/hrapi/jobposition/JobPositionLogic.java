package com.example.hrapi.jobposition;

import com.example.hrapi.jobposition.response.JobPositionResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * This class implements the logic for creating
 * a response body JobPositionResponse which is used to
 * validate the fields to be inserted then enter
 * a JobPosition into the database and returns the response
 * containing the status code and insertion
 */
@Service
@AllArgsConstructor
@Log4j2
public class JobPositionLogic {
    private final JobPositionMapper jobPositionMapper;


    public JobPositionResponse addPosition(
            String title
    ) {
        log.info("Invoke adding new JobPosition: title: {}", title);
        JobPositionResponse result = new JobPositionResponse();

        /*
        Filling Database object
         */
        JobPosition position = new JobPosition();
        position.setTitle(title);
        /*
        Insert the new JobPosition in database.
         */
        long id = jobPositionMapper.insertPosition(position);
        /*
        update inserted id in the JobPosition object
         */
        position.setId(id);
        /*
        update return result
         */
        result.setPosition(position);
        /*
        Returning result
         */
        return result;
    }
}