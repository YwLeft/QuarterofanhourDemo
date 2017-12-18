package com.example.asus.quarterofanhourdemo.base;


public class Basebean<T> {

    private String msg;
    private String code;
    private boolean guan  = false;
    private T data;

    public boolean isGuan() {
        return guan;
    }

    public void setGuan(boolean guan) {
        this.guan = guan;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
