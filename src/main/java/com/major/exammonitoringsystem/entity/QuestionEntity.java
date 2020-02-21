package com.major.exammonitoringsystem.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
public class QuestionEntity {

    String questionId;
    String question;
    List<String> options=new ArrayList<>();
}
