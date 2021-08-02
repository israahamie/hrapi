package com.example.hrapi.company;

import com.example.hrapi.shared.ResponseBody;
import com.example.hrapi.shared.StatusCodesConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * This class handles the CompanyNotFoundException
 * by providing a method which logs the exception type and the invalid id used
 * then returns a ResponseEntity with a Bad Request status and message
 */
@RestControllerAdvice
@Log4j2
public class CompanyExceptionHandler {

    @ExceptionHandler(CompanyNotFoundException.class)
    protected ResponseEntity<Object> handleCompanyNotFoundException(
            CompanyNotFoundException e) {
        log.warn("Handling Company Not found Exception: {}", e.toString());

        String message = "The Company Id: " + e.getCompanyId() + " is not valid";
        return ResponseEntity.ok(ResponseBody.BadRequest(message, StatusCodesConstants.invalidCompanyCode));


    }
}
