package com.example.hrapi.jobposition;

import com.example.hrapi.jobposition.request.NewJobPositionRequest;
import com.example.hrapi.jobposition.response.JobPositionResponse;
import com.example.hrapi.shared.ResponseBody;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The JobPositionController class links java method definitions
 * to their equivalent SQL statements/queries present in the
 * corresponding JobPositionMapper interface.
 * <p>
 * These methods can both read and write occupations from and
 * into the job_position table of the hr database.
 * <p>
 * This enables the communication with the hr database via the
 * web's http methods.
 *
 * @author Israa Hamieh
 */
@RestController
@RequestMapping("/job-positions")
@AllArgsConstructor
@Log4j2
public class JobPositionController {
    private final JobPositionMapper positionMapper;
    private final JobPositionLogic jobPositionLogic;

    /**
     * method gets the job_position by matching it to its id
     *
     * @param id the job_position entry's unique identifying id
     * @return a JobPosition object
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<JobPositionResponse>> getJobPosition(@PathVariable Long id) {
        log.info("Invoked getJobPosition method, id: {}", id);
        JobPositionResponse response = new JobPositionResponse();
        response.setPosition(positionMapper.findJobPositionById(id));
        log.info("Return response: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method gets the job_position by matching it to its title
     *
     * @param title job title
     * @return a JobPosition object
     */
    @GetMapping("/title")
    public ResponseEntity<ResponseBody<JobPositionResponse>> getPositionTitle(@RequestParam String title) {
        log.info("Invoked getPositionTitle method, id: {}", title);
        JobPositionResponse response = new JobPositionResponse();
        response.setPosition(positionMapper.findJobPositionByTitle(title));
        log.info("Return response: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method gets inserts a new job position into the job_position
     * table
     * must commit the insertion due to changing the database (adding a row)
     *
     * @param newJobPositionRequest unique id and the title of a job position
     * @return a ResponseEntity containing the fields of the JobPosition
     * inserted into the database and the status code of this request
     */
    @PostMapping()
    public ResponseEntity<ResponseBody<JobPositionResponse>> addJobPosition(@RequestBody NewJobPositionRequest newJobPositionRequest) {
        log.info("invoke addJobPosition method, New JobPosition Request :{}", newJobPositionRequest);
        /*
        Inserting the new JobPosition in the database.
         */
        JobPositionResponse response = jobPositionLogic.addPosition(newJobPositionRequest.getTitle());
        /*
        Returning response entity
         */
        log.info("Return JobPositionResponse: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }

}
