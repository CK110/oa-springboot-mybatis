package com.zjft.util;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Created by CK on 2017/8/9.
 */
@Data
@NoArgsConstructor
public class Response<T> {

    private int code;

    private T data;

    public Response(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public static Response error(ResponseCodeEnum code, String message) {
        return new Response(code.value(), new Error(message));
    }

    public static <T> Response ok(ResponseCodeEnum code, T data) {
        return new Response(code.value(), data);
    }

}
