package com.example.project1.exception;

import com.example.project1.dto.BaseResponse;
import com.example.project1.util.Constants;
import com.example.project1.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.net.ssl.SSLHandshakeException;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

@Slf4j
@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Exception.class, RuntimeException.class, ResourceAccessException.class,
            SSLHandshakeException.class})
    public ResponseEntity<BaseResponse> defaultErrorHandler(HttpServletRequest request, Exception e) {
        log.error(e.getClass() + " : " + e.getMessage() + " - Error service for request - " + request.getRequestURL(), e);
        BaseResponse response = ResponseUtil.setResponse("Failed", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ExceptionHandler(value = { DataNotFoundException.class })
    public ResponseEntity<BaseResponse> responseDataNotFoundException(DataNotFoundException e) {
        log.warn(e.getClass() + " : " + e.getMessage());
        return new ResponseEntity<>(ResponseUtil.setResponse("Failed", e.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(value = {DataFoundException.class})
    public ResponseEntity<BaseResponse> responseFoundException(DataFoundException e){
        log.warn(e.getClass() + " : " + e.getMessage());
        return new ResponseEntity<>(ResponseUtil.setResponse("Failed", e.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(value = { BodyNotFoundException.class })
    public ResponseEntity<BaseResponse> responseBodyNotFoundException(BodyNotFoundException e) {
        log.warn(e.getClass() + " : " + e.getMessage());
        return new ResponseEntity<>(ResponseUtil.setResponse("failed", e.getMessage()), HttpStatus.OK);
    }
    @ExceptionHandler(value = {InvocationTargetException.class})
    public ResponseEntity<BaseResponse> invocationTargetExceptionHandler(InvocationTargetException e) {
        log.warn(e.getClass() + " : " + e.getTargetException().getMessage() + " - " + e.getMessage(), e);

        return new ResponseEntity<>(ResponseUtil.setResponse("Failed", e.getMessage()), HttpStatus.OK);
    }
    @ExceptionHandler(value = { GetNotFoundException.class })
    public ResponseEntity<BaseResponse> responseGetNotFoundException(GetNotFoundException e) {
        log.warn(e.getClass() + " : " + e.getMessage());
        return new ResponseEntity<>(ResponseUtil.setResponse("Failed", e.getMessage()), HttpStatus.OK);
    }

}
