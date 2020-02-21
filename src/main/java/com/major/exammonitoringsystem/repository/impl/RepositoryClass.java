package com.major.exammonitoringsystem.repository.impl;


import com.major.exammonitoringsystem.customexceptions.InvalidPasswordException;
import com.major.exammonitoringsystem.entity.QuestionEntity;
import com.major.exammonitoringsystem.repository.RepositoryInterface;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositoryClass implements RepositoryInterface {

    @Override
    public Map<String,Object> checkRegisteredUser(String email, String password) throws ClassNotFoundException, SQLException, InvalidPasswordException {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/major";
        String USER = "root";
        String PASS = "";
        Class.forName(JDBC_DRIVER);
        Connection connection= DriverManager.getConnection(DB_URL,USER,PASS);
        PreparedStatement stmt=connection.prepareStatement
                ("SELECT * FROM regis where email=? and pwd=?;");
        stmt.setString(1,email);
        stmt.setString(2,password);
        ResultSet resultSet=stmt.executeQuery();
        if(!resultSet.first()){
            throw new InvalidPasswordException("Invalid Credentials!");
        }
        Map<String,Object> stringObjectMap=new HashMap<>();
        stringObjectMap.put("ID",resultSet.getString("userID"));
        stringObjectMap.put("Name",resultSet.getString("name"));
        stringObjectMap.put("Email",resultSet.getString("email"));
        stringObjectMap.put("Date of birth",resultSet.getString("dob"));
        resultSet.close();
        stmt.close();
        connection.close();
        return stringObjectMap;
    }

    @SneakyThrows
    @Override
    public void addQuestionsToDatabase(List<QuestionEntity> listOfQuestionsToAddToDatabase) {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/major";
        String USER = "root";
        String PASS = "";
        Class.forName(JDBC_DRIVER);
        Connection connection= DriverManager.getConnection(DB_URL,USER,PASS);

        String subjectName;
        String quesId;
        String ques;
        String op1;
        String op2;
        String op3;
        String op4;

        for(int i=0;i<listOfQuestionsToAddToDatabase.size();i++){
            QuestionEntity currentQuestion = listOfQuestionsToAddToDatabase.get(i);
            subjectName="subject_1";
            quesId=currentQuestion.getQuestionId();
            ques=currentQuestion.getQuestion();
            List<String> listOfOptions = currentQuestion.getOptions();
            op1=listOfOptions.get(0);
            op2=listOfOptions.get(1);
            op3=listOfOptions.get(2);
            op4=listOfOptions.get(3);

            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO ques (subject,ques_id,ques," +
                    "option1,option2,option3,option4) VALUES (?,?,?,?,?,?,?);");
            preparedStatement.setString(1,subjectName);
            preparedStatement.setString(2,quesId);
            preparedStatement.setString(3,ques);
            preparedStatement.setString(4,op1);
            preparedStatement.setString(5,op2);
            preparedStatement.setString(6,op3);
            preparedStatement.setString(7,op4);


            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        connection.close();
    }

    @SneakyThrows
    @Override
    public List<QuestionEntity> getAllQuestionsForTheSubject(String subject) {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/major";
        String USER = "root";
        String PASS = "";
        List<QuestionEntity> allQuestions=new ArrayList<>();
        Class.forName(JDBC_DRIVER);
        Connection connection= DriverManager.getConnection(DB_URL,USER,PASS);
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM ques WHERE subject=?");
        preparedStatement.setString(1,subject);
        ResultSet resultSet=preparedStatement.executeQuery();
        String quesId;
        String ques;
        String op1;
        String op2;
        String op3;
        String op4;
        while (resultSet.next()){
            quesId=resultSet.getString("ques_id");
            ques=resultSet.getString("ques");
            op1=resultSet.getString("option1");
            op2=resultSet.getString("option2");
            op3=resultSet.getString("option3");
            op4=resultSet.getString("option4");
            List<String> options=new ArrayList<>();
            options.add(op1);
            options.add(op2);
            options.add(op3);
            options.add(op4);


            QuestionEntity questionEntity=new QuestionEntity();
            questionEntity.setQuestionId(quesId);
            questionEntity.setQuestion(ques);
            questionEntity.setOptions(options);

            allQuestions.add(questionEntity);
        }
        return allQuestions;
    }
}
