package com.example.covidtrackerjava.models.dto;

public class CustomResponse {
    private Integer code;
    private Object result;

    public CustomResponse() {
    }

    public CustomResponse(Integer code, Object result) {
        this.code = code;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
