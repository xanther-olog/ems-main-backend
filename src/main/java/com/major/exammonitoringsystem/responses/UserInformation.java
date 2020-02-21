package com.major.exammonitoringsystem.responses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInformation {
    String userId;
    String name;
    String email;
    String dateOfBirth;
    String subject;
    String today_date;

    public UserInformation(String userId, String name, String email, String dateOfBirth, String subject, String today_date) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.subject = subject;
        this.today_date = today_date;
    }
}
