package com.example.hrapi.shared;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BaseResponse {

    private List errors;
}
