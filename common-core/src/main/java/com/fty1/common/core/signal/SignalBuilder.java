package com.fty1.common.core.signal;

import lombok.NonNull;

public class SignalBuilder {

    public static <T> OutSignal success() {
        return build(true, MsgCode.CODE_SUCCESS, MsgCode.MSG_SUCCESS, null);
    }

    public static <T> OutSignal success(@NonNull MsgCode msgCode) {
        return build(true, msgCode.code(), msgCode.msg(), null);
    }

    public static <T> OutSignal success(@NonNull MsgCode msgCode, T data) {
        return build(true, msgCode.code(), msgCode.msg(), data);
    }

    public static <T> OutSignal success(T data) {
        return build(true, MsgCode.CODE_SUCCESS, MsgCode.MSG_SUCCESS, data);
    }

    public static <T> OutSignal failure() {
        return build(false, MsgCode.CODE_FAILURE, MsgCode.MSG_FAILURE, null);
    }

    public static <T> OutSignal failure(@NonNull MsgCode msgCode) {
        return build(false, msgCode.code(), msgCode.msg(), null);
    }

    public static <T> OutSignal failure(@NonNull MsgCode msgCode, T data) {
        return build(false, msgCode.code(), msgCode.msg(), data);
    }

    public static <T> OutSignal failure(T data) {
        return build(false, MsgCode.CODE_FAILURE, MsgCode.MSG_FAILURE, null);
    }

    public static <T> OutSignal throwable() {
        return build(false, MsgCode.CODE_THROWABLE, MsgCode.MSG_THROWABLE, null);
    }

    private static <T> OutSignal<T> build(@NonNull Boolean success, @NonNull String code, @NonNull String msg, T data) {
        return OutSignal.<T>builder().success(success).code(code).msg(msg).data(data).build();
    }
}
