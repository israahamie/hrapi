package com.example.hrapi.jobgrade;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception is thrown when the client attempts inserting a new
 * grade that is not within the allowed range in the database
 * The exception gives an HTTP response status on the web
 * informing the client that the input is invalid
 * The exception is thrown from the insertGrade method
 *
 * @see JobGradeController
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "invalid grade input, must be <10 and >1")
public class GradeException extends Exception {
    private final String message = "grade must be between 1 and 10";

    @Override
    public String getMessage() {
        return message;
    }
}
