package com.major.exammonitoringsystem;


import com.major.exammonitoringsystem.entity.QuestionEntity;
import com.major.exammonitoringsystem.requestbody.GetAllQuestionsForASubject;
import com.major.exammonitoringsystem.requestbody.JwtTokenIncoming;
import com.major.exammonitoringsystem.requestbody.LoginRequest;
import com.major.exammonitoringsystem.responses.LoginResponse;
import com.major.exammonitoringsystem.responses.QuestionsResponse;
import com.major.exammonitoringsystem.responses.UserInformation;
import com.major.exammonitoringsystem.service.impl.ServiceClass;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/main")
public class Controller {

    @Autowired
    ServiceClass serviceClass;

    @SneakyThrows
    @PostMapping("/studentlogin")
    public ResponseEntity<LoginResponse> generateToken(@RequestBody LoginRequest loginRequest){
        String email=loginRequest.getEmail();
        String password=loginRequest.getPassword();
        Map<String,Object> mapResult =serviceClass.checkRegisteredUser(email,password);
        String jwt=serviceClass.generateJwtToken(mapResult);
        return ResponseEntity.ok(new LoginResponse(jwt));

    }


    @PostMapping("/getuserdetails")
    public ResponseEntity<UserInformation> getUserDetails(@RequestBody JwtTokenIncoming jwtTokenIncoming){
        UserInformation userInformation=serviceClass.verifyJwtToken(jwtTokenIncoming.getJwt());
        return ResponseEntity.ok(new UserInformation(userInformation.getUserId(),userInformation.getName()
        ,userInformation.getEmail(),userInformation.getDateOfBirth(),userInformation.getSubject()
                ,userInformation.getToday_date()));
    }

    @PostMapping("/addquestions")
    public String parseJson(){
        List<QuestionEntity> listOfQuestionsToAddToDatabase = serviceClass.parseJson();
        serviceClass.addQuestionsToDatabase(listOfQuestionsToAddToDatabase);
        return "done";
    }

    @PostMapping("/getquestions")
    public ResponseEntity<QuestionsResponse> getAllQuestions(@RequestBody GetAllQuestionsForASubject subjectGetter){
        serviceClass.verifyJwtToken(subjectGetter.getJwt());
        String subject=subjectGetter.getSubjectName();
        List<QuestionEntity> allQuestions=serviceClass.getAllQuestionsForASubject(subject);
        return ResponseEntity.ok(new QuestionsResponse(allQuestions));
    }

}
