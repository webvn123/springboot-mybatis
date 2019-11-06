package com.example.demo.config;

import com.example.demo.viewModel.VimData;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Administrator
 */
@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public VimData exceptionHandler(Exception e){
        VimData data = new VimData();
        data.setSuccess(false);
        data.setMessage(e.getMessage());
        return data;
    }
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public VimData bindExceptionHandler(BindException e){
        VimData data = new VimData();
        FieldError fieldError = e.getBindingResult().getFieldError();
        data.setSuccess(false);
        data.setMessage(fieldError.getDefaultMessage());
        return data;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public VimData bindMethodExceptionHandler(MethodArgumentNotValidException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        VimData data = new VimData();
        data.setSuccess(false);
        data.setMessage(fieldError.getDefaultMessage());
        return data;
    }
}
