package com.major.exammonitoringsystem.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorResponses {
    private int statusCode;
    private String message;

    public ErrorResponses(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
