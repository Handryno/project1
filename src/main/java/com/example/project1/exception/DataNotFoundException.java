package com.example.project1.exception;

public class DataNotFoundException extends Exception{
    public DataNotFoundException(String message){
        super("Data : " + message + " Tidak ditemukan");
    }
}
