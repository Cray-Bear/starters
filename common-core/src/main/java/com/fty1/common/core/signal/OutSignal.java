package com.fty1.common.core.signal;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OutSignal<T> {
    private Boolean success;
    private String code;
    private String msg;
    private T data;
}
