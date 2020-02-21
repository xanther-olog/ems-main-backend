package com.major.exammonitoringsystem.service.impl;


import com.major.exammonitoringsystem.customexceptions.JwtTokenExpiredException;
import com.major.exammonitoringsystem.entity.QuestionEntity;
import com.major.exammonitoringsystem.repository.impl.RepositoryClass;
import com.major.exammonitoringsystem.responses.UserInformation;
import com.major.exammonitoringsystem.service.ServiceInterface;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.SneakyThrows;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ServiceClass implements ServiceInterface {

    @Autowired
    RepositoryClass repositoryClass;

    @SneakyThrows
    @Override
    public Map<String, Object> checkRegisteredUser(String email, String password) {
        return repositoryClass.checkRegisteredUser(email,password);
    }

    @SneakyThrows
    @Override
    public String generateJwtToken(Map<String, Object> mapResult) {
        mapResult.put("exp",Long.toString(System.currentTimeMillis()+10800000));
        String jwt=Jwts.builder().setSubject(String.valueOf(mapResult.get("Name")))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+10800000))
                .setClaims(mapResult)
                .signWith(SignatureAlgorithm.HS256,"secret".getBytes(StandardCharsets.UTF_8))
                .compact();
        return jwt;
    }

    @SneakyThrows
    @Override
    public UserInformation verifyJwtToken(String jwt) {
        Jws<Claims> claims= Jwts.parser()
                .setSigningKey("secret".getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(jwt);
        String exp=(String) claims.getBody().get("exp");
        if(System.currentTimeMillis()>Long.parseLong(exp)){
            throw new JwtTokenExpiredException("Jwt Token has expired!");
        }
        String name= (String) claims.getBody().get("Name");
        String id= (String) claims.getBody().get("ID");
        String dob=(String) claims.getBody().get("Date of birth");
        String email=(String) claims.getBody().get("Email");
        String subject="subject_1";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String currentDate=dateFormat.format(date);

        UserInformation userInformation=new UserInformation(id,name,email,
                dob,subject,currentDate);

        return userInformation;
    }

    @SneakyThrows
    @Override
    public List<QuestionEntity> parseJson() {
        FileReader fileReader=new FileReader("/home/arkadeep/Documents/qp_set/ques.json");
        JSONParser jsonParser=new JSONParser();
        Object object=jsonParser.parse(fileReader);
        Object listOfQuestions = ((JSONObject) object).get("questions");
        List<QuestionEntity> allQuestions=new ArrayList<>();
        for(int i=0;i<((JSONArray) listOfQuestions).size();i++){
            Object currentQuestion = ((JSONArray) listOfQuestions).get(i);
            String questionId= Long.toString((Long) ((JSONObject) currentQuestion).get("id"));
            String question= (String) ((JSONObject) currentQuestion).get("question");
            Object options = ((JSONObject) currentQuestion).get("answers");
            String option1= (String) ((JSONObject) ((JSONArray) options).get(0)).get("answer");
            String option2= (String) ((JSONObject) ((JSONArray) options).get(1)).get("answer");
            String option3= (String) ((JSONObject) ((JSONArray) options).get(2)).get("answer");
            String option4= (String) ((JSONObject) ((JSONArray) options).get(3)).get("answer");

            List<String> optionsForCurrentQuestion=new ArrayList<>();
            optionsForCurrentQuestion.add(option1);
            optionsForCurrentQuestion.add(option2);
            optionsForCurrentQuestion.add(option3);
            optionsForCurrentQuestion.add(option4);

            QuestionEntity questionEntity=new QuestionEntity();

            questionEntity.setQuestionId(questionId);
            questionEntity.setQuestion(question);
            questionEntity.setOptions(optionsForCurrentQuestion);

            allQuestions.add(questionEntity);
        }

        fileReader.close();
        return allQuestions;
    }

    @Override
    public void addQuestionsToDatabase(List<QuestionEntity> listOfQuestionsToAddToDatabase) {
        repositoryClass.addQuestionsToDatabase(listOfQuestionsToAddToDatabase);
    }

    @Override
    public List<QuestionEntity> getAllQuestionsForASubject(String subject) {
        List<QuestionEntity> allQuestionList=repositoryClass.getAllQuestionsForTheSubject(subject);
        Collections.shuffle(allQuestionList);
        for(int i=0;i<allQuestionList.size();i++){
            QuestionEntity currentQuestion = allQuestionList.get(i);
            List<String> options = currentQuestion.getOptions();
            Collections.shuffle(options);
            currentQuestion.setOptions(options);
        }
        return allQuestionList;
    }
}
