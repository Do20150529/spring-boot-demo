package com.example.exception;

import com.example.enums.ResultEnum;

/**
 * Created by Ge.Mao on 2018/4/11
 */
public class UserException extends RuntimeException {
    private Integer code;

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
