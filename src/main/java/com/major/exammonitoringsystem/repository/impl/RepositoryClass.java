package com.major.exammonitoringsystem.repository.impl;


import com.major.exammonitoringsystem.customexceptions.InvalidPasswordException;
import com.major.exammonitoringsystem.repository.RepositoryInterface;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.HashMap;
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
}
