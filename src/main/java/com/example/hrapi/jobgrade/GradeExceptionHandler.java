package com.example.hrapi.jobgrade;

import com.example.hrapi.shared.ResponseBody;
import com.example.hrapi.shared.StatusCodesConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Log4j2
public class GradeExceptionHandler {
    @ExceptionHandler(GradeException.class)
    protected ResponseEntity<Object> handleGradeException(
            GradeException ex) {
        log.warn("Handling Grade Exception: {}", ex.toString());

        return ResponseEntity.ok(ResponseBody.BadRequest(ex.getMessage(), StatusCodesConstants.invalidGradeCode));


    }
}
