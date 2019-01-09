package com.commonsdk.okhttp.exception;

public class OkHttpException extends Exception {

    private Object emsg;
    private int ecode;

    public OkHttpException(Object emsg, int ecode) {
        this.emsg = emsg;
        this.ecode = ecode;
    }

    public Object getEmsg() {
        return emsg;
    }

    public int getEcode() {
        return ecode;
    }
}
