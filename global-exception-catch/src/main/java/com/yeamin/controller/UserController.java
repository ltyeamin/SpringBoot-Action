package com.yeamin.controller;

import com.alibaba.fastjson.JSON;
import com.yeamin.base.YimiResult;
import com.yeamin.constant.ResultCodeConstant;
import com.yeamin.entity.User;
import com.yeamin.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
/**
 * @Auther: tong.li
 * @Date: 2019-01-21 11:35
 * @Description: darwin 用户模块接口
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/getUser")
    public YimiResult<User> getUser(@RequestBody @Valid User user) throws Exception {
        if (user.isFlag()) {
            BusinessException e = new BusinessException(YimiResult.fail(ResultCodeConstant.INVALID_ACCOUNT, "账号已冻结!"));
            LOG.error("当前账号{}不存在!", JSON.toJSONString(user),e);
            throw e;
        }
        return  YimiResult.success(user);
    }
}
