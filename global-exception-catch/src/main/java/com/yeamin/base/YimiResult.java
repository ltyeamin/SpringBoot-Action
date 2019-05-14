package com.yeamin.base;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * @author litong
 * @date: 2018/12/3 13:17
 * @description: 接口返回结果类
 */
public class YimiResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 操作成功
     */
    private static final String SUCCESS = "SUCCESS";
    /**
     * 成功结果码
     */
    private static final String SUCCESSCODE = "000000";
    /**
     * 返回码
     */
    private String code;
    /**
     * 错误描述
     */

    private String msg;
    /**
     * 返回数据
     */
    private T data;

    private YimiResult(String code,String msg) {
        this.code = code;
        this.msg=msg;
    }

    private YimiResult(T data) {
        this.data = data;
        this.code = SUCCESSCODE;
        this.msg = SUCCESS;
    }

    public YimiResult(){}

    public static <T> YimiResult<T> success(T data){
        return new YimiResult<>(data);
    }

    public static YimiResult fail(String code, String msg){
        return new YimiResult(code,msg);
    }

    @JsonIgnore
    public boolean isSuccess(){
        return SUCCESSCODE.equals(this.code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
