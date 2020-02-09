package com.major.exammonitoringsystem.customexceptions;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String string) {
        super(string);
    }
}
