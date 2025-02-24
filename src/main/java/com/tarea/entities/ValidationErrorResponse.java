package com.tarea.entities;

import java.util.HashMap;
import java.util.Map;

public class ValidationErrorResponse {
    private Map<String, String> errors = new HashMap<>();

    public Map<String, String> getErrors() {
        return errors;
    }

    public void addError(String field, String errorMessage) {
        errors.put(field, errorMessage);
    }
}
