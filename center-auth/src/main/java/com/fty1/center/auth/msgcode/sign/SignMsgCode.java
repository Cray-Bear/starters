package com.fty1.center.auth.msgcode.sign;

import com.fty1.common.core.signal.MsgCode;

public enum  SignMsgCode implements MsgCode {

    EMPTY_IN_LOGINNO("N0001","请填写用户名"),
    EMPTY_IN_LOGINPWD("N0002","请填写密码"),
    EMPTY_CODE_IMAGE("N0003","请填写图形验证码"),
    EMPTY_CODE_SMS("N0004","请填写手机验证码"),

    NULL("","");


    private String code;
    private String msg;

    SignMsgCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String code() {
        return getCode();
    }

    @Override
    public String msg() {
        return getMsg();
    }
}
