package com.major.exammonitoringsystem.repository;



import com.major.exammonitoringsystem.customexceptions.InvalidPasswordException;
import com.major.exammonitoringsystem.entity.QuestionEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface RepositoryInterface {
    Map<String,Object> checkRegisteredUser(String email, String password) throws ClassNotFoundException, SQLException, InvalidPasswordException;

    void addQuestionsToDatabase(List<QuestionEntity> listOfQuestionsToAddToDatabase);

    List<QuestionEntity> getAllQuestionsForTheSubject(String subject);
}
