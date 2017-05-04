package com.system.core.exception;

import com.system.data.entity.Result;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by jx on 2017/4/24.
 */
public class ResultException extends Exception{
    @Getter @Setter
    private int status;

    @Getter @Setter
    private String message;

    public ResultException(int status, String message) {
        super(message);
        this.message = message;
        this.status = status;
    }
}
