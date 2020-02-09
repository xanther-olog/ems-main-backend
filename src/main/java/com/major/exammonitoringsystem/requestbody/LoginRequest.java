package com.major.exammonitoringsystem.requestbody;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginRequest {
    private String email;
    private String password;

    public LoginRequest() {
    }
}
