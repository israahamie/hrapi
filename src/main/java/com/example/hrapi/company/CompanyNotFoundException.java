package com.example.hrapi.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class is a runtime exception which occurs if a companyId
 * is not found in the company table in the database as a primary
 * key in the id column
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class CompanyNotFoundException extends RuntimeException {
    private long companyId;
}
