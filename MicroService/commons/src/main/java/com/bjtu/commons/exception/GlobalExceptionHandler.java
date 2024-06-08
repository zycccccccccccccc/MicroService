package com.bjtu.commons.exception;

import com.bjtu.commons.utils.Result;
import com.bjtu.commons.utils.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedList;


/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result<Void> exceptionHandler(CommonException ex){
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.code);
    }

    /**
     * 处理SQL异常
     * @param ex
     * @return
     */
//    @ExceptionHandler
//    public Result<Void> exceptionHandler(SQLException ex){
//        log.error("数据库异常,异常信息：{}", ex.getMessage());
//        return Result.fail(ex.getMessage());
//    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        LinkedList<String> errors = new LinkedList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            if (error instanceof FieldError) {
                FieldError err = (FieldError) error;
                errors.addLast(err.getField()+": "+error.getDefaultMessage());
            }
        });
        return Result.error(ResultCode.ARGUMENT_NOT_VALID, "参数不正确["+String.join(", ", errors)+"]");
    }
}
