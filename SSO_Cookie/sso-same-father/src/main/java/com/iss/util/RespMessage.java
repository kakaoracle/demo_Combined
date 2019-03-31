package com.iss.util;

import java.io.Serializable;
/**
 */
public class RespMessage implements Serializable{
    
    private static final long serialVersionUID = 1L;
    /** 响应编号 */
    private String respCode;
    /** 响应消息 */
    private String respMsg;
    
    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }
    
}
