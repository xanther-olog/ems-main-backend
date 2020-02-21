package com.major.exammonitoringsystem.service;



import com.major.exammonitoringsystem.customexceptions.InvalidPasswordException;
import com.major.exammonitoringsystem.entity.QuestionEntity;
import com.major.exammonitoringsystem.responses.UserInformation;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ServiceInterface {

    Map<String,Object> checkRegisteredUser(String email, String password) throws SQLException, ClassNotFoundException, InvalidPasswordException;

    String generateJwtToken(Map<String, Object> mapResult);


    UserInformation verifyJwtToken(String jwt);

    List<QuestionEntity> parseJson();

    void addQuestionsToDatabase(List<QuestionEntity> listOfQuestionsToAddToDatabase);

    List<QuestionEntity> getAllQuestionsForASubject(String subject);
}
