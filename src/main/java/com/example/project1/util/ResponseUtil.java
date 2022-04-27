package com.example.project1.util;

import com.example.project1.dto.BaseResponse;

public class ResponseUtil {
    public static BaseResponse setResponse(String status, Object data){
        BaseResponse response = new BaseResponse();
        response.setStatus(status);
        response.setData(data);
        return response;
    }
}
