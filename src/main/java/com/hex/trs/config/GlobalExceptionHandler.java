package com.hex.trs.config;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException( MethodArgumentNotValidException e ){
        Map<String,String> map =new HashMap<>();
        BindingResult results =  e.getBindingResult();
        List<FieldError> list =  results.getFieldErrors();
        list.forEach(err->{
            map.put(err.getField() , err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler( IllegalArgumentException.class)
    public  ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler( RuntimeException.class)
    public  ResponseEntity<?> handleRuntimeException(RuntimeException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
