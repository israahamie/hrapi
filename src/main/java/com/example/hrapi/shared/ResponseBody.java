package com.example.hrapi.shared;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseBody<T> {
    private String statusCode;
    private String message;
    private T response;

    public static ResponseBody success(BaseResponse response) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setResponse(response);
        responseBody.setMessage("Success");
        responseBody.setStatusCode("1001");
        return responseBody;
    }


    public static ResponseBody BadRequest(String message, String statusCode) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setMessage(message);
        responseBody.setStatusCode(statusCode);

        return responseBody;
    }


}
