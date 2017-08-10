package com.zjft.util;

/**
 * Created by CK on 2017/8/9.
 */
public enum ResponseCodeEnum {
    // SUCCESS
    SUCCESS(0),

    ERROR(1);

    private final int code;

    ResponseCodeEnum(int code) {this.code = code;}

    public int value() {
        return code;
    }
}
