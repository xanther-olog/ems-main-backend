package com.major.exammonitoringsystem.service.impl;


import com.major.exammonitoringsystem.repository.impl.RepositoryClass;
import com.major.exammonitoringsystem.service.ServiceInterface;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

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
}
