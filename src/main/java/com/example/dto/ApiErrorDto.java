package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ApiErrorDto {

    @JsonProperty("field_errors")
    private List<ApiFieldErrorDto> fieldErrors = new ArrayList<>();

    public List<ApiFieldErrorDto> getFieldErrors() {
        return fieldErrors;
    }

    public void addFieldError(String name, String message) {
        fieldErrors.add(new ApiFieldErrorDto(name, message));
    }
}
