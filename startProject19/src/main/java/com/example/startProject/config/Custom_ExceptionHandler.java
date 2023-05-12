package com.example.startProject.config;
import com.example.startProject.dtos.ErrorResponse;

import com.example.startProject.exceptions.BadPersonRequestException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@ControllerAdvice
public class Custom_ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(BadPersonRequestException.class)
    public ResponseEntity handleMethodArgumentNotValidException(BadPersonRequestException ex)
    {
//        BindingResult result   =   ex.getBindingResult();
//        List<FieldError> fieldErrors = result.getFieldErrors();
//        List<String>  errors = fieldErrors.stream()
//                .map(x->x.getDefaultMessage()).collect(Collectors.toList());
List<String> customMessage  = new ArrayList<>();
customMessage.add("Person with Id does not exists");
        ErrorResponse errorResponse  = new ErrorResponse(customMessage, HttpStatus.NOT_FOUND,
                ex.getMessage(), "ERR_501%") ;


        return new ResponseEntity( errorResponse , HttpStatus.NOT_ACCEPTABLE);


    }


//    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
//    public ResponseEntity handleMethodArgumentNotValidException(Exception ex)
//    {
//        BindingResult result   =   ex.getBindingResult();
//        List<FieldError> fieldErrors = result.getFieldErrors();
//        List<String>  errors = fieldErrors.stream()
//                .map(x->x.getDefaultMessage()).collect(Collectors.toList());
//
//
//        ErrorResponse errorResponse  = new ErrorResponse(errors, HttpStatus.NOT_ACCEPTABLE,
//                ex.getMessage(), "ERR_501%") ;
//
//
//        return new ResponseEntity( errorResponse , HttpStatus.NOT_ACCEPTABLE);
//
//
//    }

}
