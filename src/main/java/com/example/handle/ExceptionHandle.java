package com.example.handle;

import com.example.domain.Result;
import com.example.exception.UserException;
import com.example.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 捕获异常
 * Created by Ge.Mao on 2018/4/10
 */
@RestControllerAdvice
public class ExceptionHandle {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e) {
        if (e instanceof UserException) {
            UserException userException = (UserException)e;
            return ResultUtil.error(userException.getCode(), userException.getMessage());
        } else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
