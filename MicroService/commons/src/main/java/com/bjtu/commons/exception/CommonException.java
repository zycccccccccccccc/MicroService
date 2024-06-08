package com.bjtu.commons.exception;

import com.bjtu.commons.utils.ResultCode;

/**
 * 业务异常
 */
public class CommonException extends RuntimeException {
    public final ResultCode code;

    public CommonException() {
        this(ResultCode.FAILED);
    }

    public CommonException(ResultCode code) {
        super(code.defaultMsg);
        this.code = code;
    }
}
