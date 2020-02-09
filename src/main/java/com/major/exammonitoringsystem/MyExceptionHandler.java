package com.major.exammonitoringsystem;

import com.fasterxml.jackson.core.JsonParseException;
import com.major.exammonitoringsystem.customexceptions.InvalidPasswordException;
import com.major.exammonitoringsystem.customexceptions.JwtTokenExpiredException;
import com.major.exammonitoringsystem.responses.ErrorResponses;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({JsonParseException.class})
    public ResponseEntity<Object> handleUnableToParseJsonException(JsonParseException ex,
                                                                   WebRequest webRequest){
        ErrorResponses errorResponses=new ErrorResponses(400,"Couldn't validate Json");
        return this.handleExceptionInternal(ex,errorResponses,new HttpHeaders(),HttpStatus.BAD_REQUEST,webRequest);
    }

    @ExceptionHandler({SignatureException.class})
    public ResponseEntity<Object> handleInValidJwtSignature(SignatureException ex, WebRequest webRequest){
        ErrorResponses errorResponses=new ErrorResponses(400,"Invalid JWT signature!");
        return this.handleExceptionInternal(ex,errorResponses,new HttpHeaders(),HttpStatus.BAD_REQUEST,webRequest);
    }

    @ExceptionHandler({InvalidPasswordException.class})
    public ResponseEntity<Object> handleInvalidCredentials(InvalidPasswordException ex, WebRequest webRequest){
        ErrorResponses errorResponses=new ErrorResponses(400,"Invalid credentials!");
        return this.handleExceptionInternal(ex,errorResponses,new HttpHeaders(),HttpStatus.BAD_REQUEST,webRequest);
    }

    @ExceptionHandler({SQLException.class})
    public ResponseEntity<Object> handleSQLException(SQLException ex, WebRequest webRequest){
        ErrorResponses errorResponses=new ErrorResponses(500,"Database error!");
        return this.handleExceptionInternal(ex,errorResponses,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR,webRequest);
    }

    @ExceptionHandler({ClassNotFoundException.class})
    public ResponseEntity<Object> handleClassNotFoundException(ClassNotFoundException ex, WebRequest webRequest){
        ErrorResponses errorResponses=new ErrorResponses(500,"Class not found error!");
        return this.handleExceptionInternal(ex,errorResponses,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR,webRequest);
    }

    @ExceptionHandler({JwtTokenExpiredException.class})
    public ResponseEntity<Object> handleClassNotFoundException(JwtTokenExpiredException ex, WebRequest webRequest){
        ErrorResponses errorResponses=new ErrorResponses(500,"Jwt Token has expired!");
        return this.handleExceptionInternal(ex,errorResponses,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR,webRequest);
    }

}
