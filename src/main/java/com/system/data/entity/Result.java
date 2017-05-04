package com.system.data.entity;

import com.system.core.exception.ResultException;
import com.system.core.util.HttpStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by jx on 2017/4/24.
 */
public class Result implements Serializable{
    @Getter @Setter
    private int status;

    @Getter @Setter
    private String message;

    @Getter @Setter
    private Map<String, Object> data;

    private Result(int status, String message) {
        this(status, message, null);
    }

    private Result(int status, String message, Map<String, Object> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static Result returnJson(int status, String message, Map<String, Object> data) {
        return new Result(status, message, data);
    }

    public static Result returnError(Errors errors) {
        return returnError(errors, null);
    }

    public static Result returnError(Errors errors, Map<String, Object> data) {
        String message = "";
        if (errors.hasErrors()) {
            FieldError error = errors.getFieldError();
            String field = error.getField();
            String err = error.getDefaultMessage();
            message = field + ":" + err;
        }
        return new Result(HttpStatus.ERROR, message, data);
    }

    public static Result returnException(ResultException exception) {
        return new Result(exception.getStatus(), exception.getMessage(), null);
    }
}
