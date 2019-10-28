package com.wechat.localtest.util;


import com.wechat.localtest.constant.CommonConstant;

/**
 * @description: 响应
 * @author: kakaoracle
 * @create: 2019-02-23 22:57
 **/
public class MsgResult {
    // 响应业务状态
    private Integer code;

    // 响应消息
    private String message;

    // 响应中的数据
    private Object data;

    public MsgResult() {

    }

    public MsgResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public MsgResult(Object data) {
        this.code = CommonConstant.HTTP_CODE_OK;
        this.message = CommonConstant.HTTP_STATUS_OK;
        this.data = data;
    }

    public static MsgResult build(Integer code, String message) {
        return new MsgResult(code, message, null);
    }

    public static MsgResult build(Integer code, String message, Object data) {
        return new MsgResult(code, message, data);
    }

    public static MsgResult ok(Object data) {
        return new MsgResult(data);
    }

    public static MsgResult ok() {
        return new MsgResult(null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MsgResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
