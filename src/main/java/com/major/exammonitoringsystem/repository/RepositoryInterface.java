package com.major.exammonitoringsystem.repository;



import com.major.exammonitoringsystem.customexceptions.InvalidPasswordException;

import java.sql.SQLException;
import java.util.Map;

public interface RepositoryInterface {
    Map<String,Object> checkRegisteredUser(String email, String password) throws ClassNotFoundException, SQLException, InvalidPasswordException;
}
