package com.yeamin.base;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * @Auther: litong
 * @Date: 2018-12-29 14:03
 * @Description: ResultFactory
 */
@Component
public class ResultFactory implements InitializingBean {

    private static MessageSource messageSource;

    @Autowired
    ApplicationContext context;


    @Override
    public void afterPropertiesSet() throws Exception {
        messageSource= (MessageSource)context.getBean("messageSource");
    }


    public static YimiResult createResult(String code){
        return YimiResult.fail(code,messageSource.getMessage(code,null,null));
    }

    public static YimiResult createResult(String code, String extraMsg){
        return YimiResult.fail(code,messageSource.getMessage(code,null,null) + extraMsg);
    }
}
