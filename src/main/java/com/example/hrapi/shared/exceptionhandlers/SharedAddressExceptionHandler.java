package com.example.hrapi.shared.exceptionhandlers;

import com.example.hrapi.shared.ResponseBody;
import com.example.hrapi.shared.StatusCodesConstants;
import com.example.hrapi.shared.exception.AddressNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * This class handles the AddressNotFoundException
 * by providing a method which logs the exception type and the invalid id used
 * then returns a ResponseEntity with a Bad Request status and message
 */
@RestControllerAdvice
@Log4j2
public class SharedAddressExceptionHandler {

    @ExceptionHandler(AddressNotFoundException.class)
    protected ResponseEntity<Object> handleAddressNotFoundException(
            AddressNotFoundException ex) {
        log.warn("Handling Address Not found Exception: {}", ex.toString());

        String message = "The Address Id: " + ex.getAddressId() + " is Not VALID";
        return ResponseEntity.ok(ResponseBody.BadRequest(message, StatusCodesConstants.invalidAddressCode));


    }
}
