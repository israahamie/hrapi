package com.example.hrapi.jobhistory;

import com.example.hrapi.company.Company;
import com.example.hrapi.company.CompanyMapper;
import com.example.hrapi.employee.Employee;
import com.example.hrapi.employee.EmployeeMapper;
import com.example.hrapi.jobgrade.GradeException;
import com.example.hrapi.jobhistory.response.JobHistoryResponse;
import com.example.hrapi.jobposition.JobPosition;
import com.example.hrapi.jobposition.JobPositionMapper;
import com.example.hrapi.shared.exception.CompanyNotFoundException;
import com.example.hrapi.shared.exception.EmployeeNotFoundException;
import com.example.hrapi.shared.exception.PositionNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * This class implements the logic for creating
 * a response body JobHistoryResponse which is used to
 * validate the fields to be inserted then enter
 * a JobHistory into the database and returns the response
 * containing the status code and insertion
 */
@Service
@AllArgsConstructor
@Log4j2
public class JobHistoryLogic {
    private final JobHistoryMapper jobHistoryMapper;

    private final EmployeeMapper employeeMapper;
    private final CompanyMapper companyMapper;
    private final JobPositionMapper jobPositionMapper;

    public JobHistoryResponse addJobHistory(

            long employeeId,
            long companyId,
            long positionId,
            Date fromDate,
            Date toDate,
            boolean isCurrent
    ) throws GradeException {
        log.info("Invoke adding new JobHistory: isCurrent: {}", isCurrent);
        JobHistoryResponse result = new JobHistoryResponse();
      /*
        Validate that the employee id, company id, and position id exist and are correct.
         */

        Employee employee = employeeMapper.findEmployeeById(employeeId);
        Company company = companyMapper.findCompanyById(companyId);
        JobPosition position = jobPositionMapper.findJobPositionById(positionId);

        /*
        Handle if address, company, or position is not valid.
         */
        if (employee == null) {
            throw new EmployeeNotFoundException(employeeId);
        }
        if (company == null) {
            throw new CompanyNotFoundException(companyId);
        }
        if (position == null) {
            throw new PositionNotFoundException(positionId);
        }
        /*
        Filling Database object
         */
        JobHistory jobHistory = new JobHistory();
        jobHistory.setCompany(company);
        jobHistory.setEmployee(employee);
        jobHistory.setPosition(position);
        jobHistory.setFromDate(fromDate);
        jobHistory.setToDate(toDate);
        jobHistory.setCurrent(isCurrent);
        /*
        Insert the new JobHistory in database.
         */
        long id = jobHistoryMapper.insertHistory(jobHistory);
        /*
        update inserted id in the JobHistory object
         */
        employee.setId(id);
        /*
        update return result
         */
        result.setHistory(jobHistory);
        /*
        Returning result
         */
        return result;
    }
}
