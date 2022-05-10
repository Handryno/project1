package com.example.project1.dto;

import lombok.Data;

@Data
public class BaseResponse {
    private String status;
    private Object data;
}

