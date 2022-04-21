package com.example.project1.exception;

public class WrongFormatException extends Exception{
    public WrongFormatException(String fieldMessage) {
        super("Field : " + fieldMessage);
    }
}
