package com.jing.qiongyou.model;

/**
 * Created by Ding.pengqiang
 * on 2017/3/27.
 */

public class Response< T >{

    /**
     *  "status": 1,
        "info": "",
        "times": 0,
        "data":{}
        "extra":{}
        "ra_referer": ""
     */
    private int status;

    private String info;

    private Long times;

    private T data;

    private T extra;

    private String ra_referer;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getExtra() {
        return extra;
    }

    public void setExtra(T extra) {
        this.extra = extra;
    }

    public String getRa_referer() {
        return ra_referer;
    }

    public void setRa_referer(String ra_referer) {
        this.ra_referer = ra_referer;
    }
}
