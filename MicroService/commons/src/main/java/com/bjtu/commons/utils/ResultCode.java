package com.bjtu.commons.utils;


public enum ResultCode {
    /**
     * 0: 成功
     */
    SUCCESS(0, "成功"),
    /**
     * 100 - 1000 常规
     */
    FAILED(101, "失败"),
    ARGUMENT_NOT_VALID(102, "参数不正确"),
    /**
     * 1000 - 2000 user
     */
    LOGIN_ERROR(1001, "账号或密码错误"),
    ACCOUNT_NOT_FOUND(1002, "账号不存在"),
    ACCOUNT_LOCKED(1003, "账号被锁定"),
    USER_NAME_EXISTS(1004, "用户名已存在"),
    USER_ID_EXISTS(1005, "用户id已存在");

    public final Integer value;
    public final String defaultMsg;

    ResultCode(Integer value, String defaultMsg) {
        this.value = value;
        this.defaultMsg = defaultMsg;
    }
}
