package com.example.jwtsecurity.common;

import java.awt.*;

/**
 * @author Administrator
 */
public class CommonResult<T> {
    public CommonResult(){
        this.setSuccess(true);
        this.setMessage("");
    }
    public CommonResult(boolean success,String msg){
        this.success = success;
        this.message = msg;
    }
    public  CommonResult (T data){
        this.data = data;
        this.success = true;
    }
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private Boolean success;
    private T data;
}

