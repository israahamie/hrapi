package com.example.hrapi.jobposition.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class implements a request the client can send
 * containing the fields necessary to create a new
 * JobPosition and add it to the database
 */

@Getter
@Setter
@ToString
public class NewJobPositionRequest {
    private String title;

}
