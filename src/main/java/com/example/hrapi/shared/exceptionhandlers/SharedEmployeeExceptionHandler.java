package com.example.hrapi.shared.exceptionhandlers;

import com.example.hrapi.shared.ResponseBody;
import com.example.hrapi.shared.StatusCodesConstants;
import com.example.hrapi.shared.exception.EmployeeNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * This class handles the EmployeeNotFoundException
 * by providing a method which logs the exception type and the invalid id used
 * then returns a ResponseEntity with a Bad Request status and message
 */
@RestControllerAdvice
@Log4j2
public class SharedEmployeeExceptionHandler {
    @ExceptionHandler(EmployeeNotFoundException.class)
    protected ResponseEntity<Object> handleEmployeeNotFoundException(
            EmployeeNotFoundException e) {
        log.warn("Handling Employee Not found Exception: {}", e.toString());

        String message = "The Employee Id: " + e.getEmployeeId() + " is not VALID";
        return ResponseEntity.ok(ResponseBody.BadRequest(message, StatusCodesConstants.invalidEmployeeCode));


    }
}
