package com.example.startProject.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private List<String> message;
    private HttpStatus status;
    private String devMessage;
    private String errorCode;








}
