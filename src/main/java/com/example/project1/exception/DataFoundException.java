package com.example.project1.exception;

public class DataFoundException extends Exception{
    public DataFoundException(String message){
        super("Data : " + message + " Sudah ada");
    }
}
