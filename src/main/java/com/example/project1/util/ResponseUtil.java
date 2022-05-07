package com.example.project1.util;

import com.example.project1.dto.BaseResponse;

public class ResponseUtil {
    public static BaseResponse setResponse(String status, Object data) {
        BaseResponse res = new BaseResponse();
        res.setStatus(status);
        res.setData(data);
        return res;
    }
}
