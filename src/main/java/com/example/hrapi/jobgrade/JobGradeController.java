package com.example.hrapi.jobgrade;

import com.example.hrapi.department.DepartmentNotFoundException;
import com.example.hrapi.employee.EmployeeNotFoundException;
import com.example.hrapi.jobgrade.request.NewJobGradeRequest;
import com.example.hrapi.jobgrade.response.JobGradeResponse;
import com.example.hrapi.jobgrade.response.JobGradesResponse;
import com.example.hrapi.jobposition.PositionNotFoundException;
import com.example.hrapi.shared.ResponseBody;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The JobGradeController class links java method definitions
 * to their equivalent SQL statements/queries present in the
 * corresponding JobGradeMapper interface.
 * <p>
 * These methods can both read and write job evaluations from and to
 * the job_grade table of the hr database.
 * <p>
 * This enables the communication with the hr database via the
 * web's http methods.
 *
 * @author Israa Hamieh
 */
@RestController
@RequestMapping("/job-grade")
@AllArgsConstructor
@Log4j2
public class JobGradeController {
    private final JobGradeMapper jobGradeMapper;
    private final JobGradeLogic jobGradeLogic;

    /**
     * method gets the JobGrade by matching it to its id
     *
     * @param id the JobGrade entry's unique identifying id
     * @return a JobGrade object
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<JobGradeResponse>> getJobGrade(@PathVariable Long id) {
        log.info("Invoked getJobGrade method, id: {}", id);
        JobGradeResponse response = new JobGradeResponse();
        response.setJobGrade(jobGradeMapper.findJobGradeById(id));
        log.info("Return response: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method gets the JobGrade by matching it to its employee
     *
     * @param employee_id the JobGrade entry's employee id
     *                    to which grade belongs to
     * @return a JobGrade object
     */
    @GetMapping("/employee")
    public ResponseEntity<ResponseBody<JobGradeResponse>> getJobGradeByEmployee(@RequestParam Long employee_id) {
        log.info("Invoked getJobGradeByEmployee method, employee id: {}", employee_id);
        JobGradesResponse response = new JobGradesResponse();
        response.setJobGrades(jobGradeMapper.findJobGradeByEmployee(employee_id));
        log.info("Return response: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }


    /**
     * method gets the JobGrade by matching it to the occupation
     *
     * @param position_id the JobGrade entry's position id
     *                    to which grade belongs to
     * @return a JobGrade list
     */
    @GetMapping("/position")
    public ResponseEntity<ResponseBody<JobGradeResponse>> getJobGradeByPosition(@RequestParam Long position_id) {
        log.info("Invoked getJobGradeByPosition method, position id: {}", position_id);
        JobGradesResponse response = new JobGradesResponse();
        response.setJobGrades(jobGradeMapper.findJobGradeByPosition(position_id));
        log.info("Return response: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method gets the JobGrade by matching it to the department
     *
     * @param department_id the JobGrade entry's department id
     *                      to which grade belongs to
     * @return a JobGrade list
     */
    @GetMapping("/department")
    public ResponseEntity<ResponseBody<JobGradeResponse>> getJobGradeByDepartment(@RequestParam Long department_id) {
        log.info("Invoked getJobGradeByDepartment method, department id: {}", department_id);
        JobGradesResponse response = new JobGradesResponse();
        response.setJobGrades(jobGradeMapper.findJobGradeByDepartment(department_id));
        log.info("Return response: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method gets the JobGrade by matching it to the grade given
     *
     * @param grade the JobGrade entry's grade
     *              to which grade belongs to
     * @return a JobGrade list
     */
    @GetMapping("/grade")
    public ResponseEntity<ResponseBody<JobGradeResponse>> getJobGradeByGrade(@RequestParam Short grade) {
        log.info("Invoked getJobGradeByGrade method, grade: {}", grade);
        JobGradesResponse response = new JobGradesResponse();
        response.setJobGrades(jobGradeMapper.findJobGradeByGrade(grade));
        log.info("Return response: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));
    }

    /**
     * method adds a new row to the job_grade table
     *
     * @param newJobGradeRequest the fields required for a
     *                           a new row
     * @return a ResponseEntity containing the fields of the JobGrade
     * inserted into the database and the status code of this request
     * @throws EmployeeNotFoundException   in case the foreign
     *                                     employee key does not exist in the employee table
     *                                     and is thus not a valid key
     * @throws DepartmentNotFoundException in case the foreign
     *                                     department key does not exist in the department table
     *                                     and is thus not a valid reference to an department
     * @throws PositionNotFoundException   in case the foreign
     *                                     job_position key does not exist in the job_key table
     *                                     as a primary key and is thus not a valid key
     */
    @PostMapping("/add")
    public ResponseEntity<ResponseBody<JobGradeResponse>> addJobGrade(@RequestBody NewJobGradeRequest newJobGradeRequest) throws GradeException {
        log.info("invoke addJobGrade method, New JobGrade Request :{}", newJobGradeRequest);
        /*
        Inserting the new JobGrade in the database.
         */
        JobGradeResponse response = jobGradeLogic.addJobGrade(
                newJobGradeRequest.getEmployeeId(),
                newJobGradeRequest.getDepartmentId(),
                newJobGradeRequest.getPositionId(),
                newJobGradeRequest.getGrade()
        );
        /*
        Returning response entity
         */
        log.info("Return JobGradeResponse: {}", response);
        return ResponseEntity.ok(ResponseBody.success(response));

    }
}
