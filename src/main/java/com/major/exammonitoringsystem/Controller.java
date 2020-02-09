package com.major.exammonitoringsystem;


import com.major.exammonitoringsystem.customexceptions.JwtTokenExpiredException;
import com.major.exammonitoringsystem.requestbody.LoginRequest;
import com.major.exammonitoringsystem.responses.LoginResponse;
import com.major.exammonitoringsystem.service.impl.ServiceClass;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Date;
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


    @SneakyThrows
    @PostMapping("/verify/{jwt}")
    public String verifyJwt(@PathVariable ("jwt") String jwt){
        Jws<Claims> claims= Jwts.parser()
                .setSigningKey("secret".getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(jwt);
        String exp=(String) claims.getBody().get("exp");
        if(System.currentTimeMillis()>Long.parseLong(exp)){
            throw new JwtTokenExpiredException("Jwt Token has expired!");
        }
        String name= (String) claims.getBody().get("Name");
        String email= (String) claims.getBody().get("Email");
        return name;
    }


}
