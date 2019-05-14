package com.yeamin.exception;

import com.yeamin.base.YimiResult;

/**
 * @Auther: tong.li
 * @Date: 2019-01-21 11:35
 * @Description: darwin 流程中断异常
 */
public class BusinessException extends RuntimeException{
    private YimiResult yimiResult;

    public YimiResult getYimiResult() {
        return yimiResult;
    }

    public void setYimiResult(YimiResult yimiResult) {
        this.yimiResult = yimiResult;
    }

    //无参构造方法
    public BusinessException(){

        super();
    }

    //有参的构造方法
    public BusinessException(String message){
        super(message);

    }

    // 用指定的详细信息和原因构造一个新的异常
    public BusinessException(String message, Throwable cause){

        super(message,cause);
    }

    //用指定原因构造一个新的异常
    public BusinessException(Throwable cause) {

        super(cause);
    }

    public BusinessException(YimiResult yimiResult,String message   ) {
        super(message);
        this.yimiResult=yimiResult;
    }

    public BusinessException(YimiResult yimiResult) {
        this.yimiResult=yimiResult;
    }

    public  static BusinessException pauseException(YimiResult yimiResult, String message){
        return new BusinessException(yimiResult,message);
    }

}
