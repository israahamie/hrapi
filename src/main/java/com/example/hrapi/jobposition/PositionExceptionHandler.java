package com.example.hrapi.jobposition;

import com.example.hrapi.shared.ResponseBody;
import com.example.hrapi.shared.StatusCodesConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * This class handles the PositionNotFoundException
 * by providing a method which logs the exception type and the invalid id used
 * then returns a ResponseEntity with a Bad Request status and message
 */
@RestControllerAdvice
@Log4j2
public class PositionExceptionHandler {

    @ExceptionHandler(PositionNotFoundException.class)
    protected ResponseEntity<Object> handlePositionNotFoundException(
            PositionNotFoundException e) {
        log.warn("Handling Position not found Exception: {}", e.toString());

        String message = "The JobPosition Id: " + e.getJobPositionId() + " is not VALID";
        return ResponseEntity.ok(ResponseBody.BadRequest(message, StatusCodesConstants.invalidPositionCode));


    }
}
