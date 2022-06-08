package com.example.zeroproject11.advice;

import com.example.zeroproject11.dto.ApiResponce;
import com.example.zeroproject11.exsptions.InvalidExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviseHandler {
    private final Logger log = LoggerFactory.getLogger(ControllerAdviseHandler.class);

    @ExceptionHandler(value = InvalidExceptions.class)
    public ResponseEntity<ApiResponce> handleException(InvalidExceptions idExceptions){
        String message = idExceptions.getMessage();
        log.info(message);
        return ResponseEntity.status(400).body(new ApiResponce(message,400));
    }
}
