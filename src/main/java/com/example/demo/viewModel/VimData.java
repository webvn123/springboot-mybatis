package com.example.demo.viewModel;

/**
 * @author Administrator
 */
public class VimData<T> {
    public VimData(){
        this.setSuccess(true);
        this.setMessage("");
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

