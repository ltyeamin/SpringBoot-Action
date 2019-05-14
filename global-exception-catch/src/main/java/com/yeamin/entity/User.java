package com.yeamin.entity;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @Auther: tong.li
 * @Date: 2019-01-21 11:35
 * @Description: darwin 用户实体
 */
public class User implements Serializable {

    private static final long serialVersionUID = 4359709211352400087L;

    @NotNull(message = "用户ID不能为空")
    public Long id;
    @NotBlank(message = "用户ID不能为空")
    public String name;
    @NotBlank(message = "手机号不能为空")
    @Size(max = 11, min = 11, message = "手机号只能为11位")
    public String tel;
    @Min(value = 1, message = "最小年龄为1岁")
    @Max(value = 100, message = "最大年龄为120岁")
    Integer age;

    /**
     * 用户冻结标志位
     */
    public boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
