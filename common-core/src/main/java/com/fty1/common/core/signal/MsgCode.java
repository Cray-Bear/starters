package com.fty1.common.core.signal;

public interface MsgCode {

    String CODE_SUCCESS = "1";
    String CODE_FAILURE = "0";
    String CODE_THROWABLE = "-1";

    String MSG_SUCCESS = "操作成功";
    String MSG_FAILURE = "操作失败";
    String MSG_THROWABLE = "系统异常";

    String code();
    String msg();
}
