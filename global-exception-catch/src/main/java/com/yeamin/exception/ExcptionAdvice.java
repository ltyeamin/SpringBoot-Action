package com.yeamin.exception;

import com.alibaba.fastjson.JSON;
import com.yeamin.base.ResultFactory;
import com.yeamin.base.YimiResult;
import com.yeamin.constant.ResultCodeConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author tong.li
 * @date: 2018/12/4 10:56
 * @description: 参数异常统一处理
 */

@RestControllerAdvice
public class ExcptionAdvice {

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    /**
     *  统一异常处理
     * @author 李彤
     * @param exception  异常
     * @return java.lang.Object
     * @date 2019-01-11
     */
    @ExceptionHandler(Exception.class)
    public Object validExceptionHandler(Exception exception) {


        if (exception instanceof MethodArgumentNotValidException) {
            return YimiResult.fail(ResultCodeConstant.PARAMS_ERROR, appendAllFieldError(
                    ((MethodArgumentNotValidException) exception).getBindingResult().getFieldErrors(), exception));
        } else if (exception instanceof BindException) {
            return YimiResult.fail(ResultCodeConstant.PARAMS_ERROR, appendAllFieldError(
                    ((BindException) exception).getBindingResult().getFieldErrors(), exception));
        } else if(exception instanceof BusinessException){
            BusinessException e=(BusinessException) exception;
            log.info("validExceptionHander 报错内容{}",e.getMessage());
            log.info("BusinessException reslut {}", JSON.toJSONString(e.getYimiResult()));
            return e.getYimiResult();
        }

        //未处理异常
        log.error("occur unhandle exception: {}, errorMsg: {}", exception.getClass().getName(), exception.getMessage(), exception);
        return ResultFactory.createResult(ResultCodeConstant.EXCEPTION);
    }



    /**
     * 拼接所有错误字段信息
     * @author 李彤
     * @param fieldErrors  所有错误字段实体
     * @param exception 异常
     * @return java.lang.String
     * @date 2019-01-11
     */
    private String appendAllFieldError(List<FieldError> fieldErrors, Exception exception){
        StringBuilder allFieldErrorMsg = new StringBuilder();
        if (!ObjectUtils.isEmpty(fieldErrors)) {
            for (FieldError fieldError : fieldErrors) {
                allFieldErrorMsg.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append("; ");
            }
        }
        log.warn("occur handled exception: {}, errorMsg: {}", exception.getClass().getName(), allFieldErrorMsg.toString());
        return allFieldErrorMsg.toString();
    }

}
