package com.major.exammonitoringsystem.responses;

import com.major.exammonitoringsystem.entity.QuestionEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class QuestionsResponse {
    List<QuestionEntity> allQuestions;

    public QuestionsResponse(List<QuestionEntity> allQuestions) {
        this.allQuestions = allQuestions;
    }
}
