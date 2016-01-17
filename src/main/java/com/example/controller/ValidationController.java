package com.example.controller;

import com.example.dto.ApiErrorDto;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ValidationController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorDto handle(MethodArgumentNotValidException exception) {
        val apiErrorDto = new ApiErrorDto();

        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            apiErrorDto.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return apiErrorDto;
    }
}
