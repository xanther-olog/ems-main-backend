package com.major.exammonitoringsystem.service;



import com.major.exammonitoringsystem.customexceptions.InvalidPasswordException;

import java.sql.SQLException;
import java.util.Map;

public interface ServiceInterface {

    Map<String,Object> checkRegisteredUser(String email, String password) throws SQLException, ClassNotFoundException, InvalidPasswordException;

    String generateJwtToken(Map<String, Object> mapResult);
}
