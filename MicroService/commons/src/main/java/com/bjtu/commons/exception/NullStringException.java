package com.bjtu.commons.exception;

import com.bjtu.commons.utils.ResultCode;

/**
 * 输入字符串为空异常
 */
public class NullStringException extends CommonException {
    public NullStringException(String msg){
        super(ResultCode.FAILED);
    }
}
