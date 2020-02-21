package com.major.exammonitoringsystem.requestbody;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetAllQuestionsForASubject {
    String jwt;
    String subjectName;
}
