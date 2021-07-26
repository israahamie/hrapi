package com.example.hrapi.jobhistory;

import com.example.hrapi.jobgrade.GradeException;
import com.example.hrapi.jobhistory.request.NewJobHistoryRequest;
import com.example.hrapi.jobhistory.response.JobHistoriesResponse;
import com.example.hrapi.jobhistory.response.JobHistoryResponse;
import com.example.hrapi.shared.ResponseBody;
import com.example.hrapi.shared.exception.CompanyNotFoundException;
import com.example.hrapi.shared.exception.EmployeeNotFoundException;
import com.example.hrapi.shared.exception.PositionNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The JobHistoryController class links java method definitions
 * to their equivalent SQL statements/queries present in the
 * corresponding AddressMapper interface.
 * <p>
 * These methods can both read employees' job records
 * and write new job entries into the job_history table of the hr
 * database.
 * <p>
 * This enables the communication with the hr database via the
 * web's http methods.
 *
 * @author Israa Hamieh
 */
@RestController
@RequestMapping("/job-histories")
@AllArgsConstructor
@Log4j2
public class jobHistoryController {
    private final JobHistoryMapper historyMapper;
    private final JobHistoryLogic historyLogic;

    /**
     * method gets the jobHistory by matching it to its employee
     *
     * @param employee_id the employee that occupies the jobs
     * @return a JobHistory list
     */
    @GetMapping("/employee")
    public ResponseEntity<ResponseBody<JobHistoryResponse>> getEmployeeHistory(@RequestParam Long employee_id) {
        log.info("Invoked getEmployeeHistory method, employee id: {}", employee_id);
        JobHistoriesResponse response = new JobHistoriesResponse();
        response.setJobHistories(historyMapper.findJobHistoryByEmployee(employee_id));
        log.info("Return response: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method inserts a new job and duration of the employee's work
     * must commit the insertion due to changing the database (adding a row)
     *
     * @param newJobHistoryRequest needed fields for a new row
     * @return a ResponseEntity containing the fields
     * of the JobHistory inserted into the database and the
     * status code of this request
     * @throws EmployeeNotFoundException in case the foreign
     *                                   employee key does not exist in the employee table
     *                                   and is thus not a valid reference to an employee
     * @throws CompanyNotFoundException  in case the foreign
     *                                   company key does not exist in the company table
     *                                   and is thus not a valid reference to a company
     * @throws PositionNotFoundException in case the foreign
     *                                   job_position key does not exist in the job_key table
     *                                   as a primary key and is thus not a valid key
     */
    @PostMapping()
    public ResponseEntity<ResponseBody<JobHistoryResponse>> addJobHistory(@RequestBody NewJobHistoryRequest newJobHistoryRequest) throws GradeException {
        log.info("invoke addJobHistory method, New JobHistory Request :{}", newJobHistoryRequest);
        /*
        Inserting the new JobHistory in the database.
         */
        JobHistoryResponse response = historyLogic.addJobHistory(
                newJobHistoryRequest.getEmployeeId(),
                newJobHistoryRequest.getCompanyId(),
                newJobHistoryRequest.getPositionId(),
                newJobHistoryRequest.getFromDate(),
                newJobHistoryRequest.getToDate(),
                newJobHistoryRequest.isCurrent()
        );
        /*
        Returning response entity
         */
        log.info("Return JobHistoryResponse: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }

}
