package com.system.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by jx on 2017/4/24.
 */
public class User {
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    @SafeHtml
    @Email(message = "邮箱格式不正确")
    @NotNull(message = "邮箱未提交")
    @NotEmpty(message = "邮箱不可为空")
    private String email;

    @Getter @Setter
    @SafeHtml
    @NotNull(message = "密码未提交")
    @NotEmpty(message = "密码不可为空")
    private String password;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String address;

    @Getter @Setter
    private int gender;

    @Getter @Setter
    private String profession;

    @Getter @Setter
    private Integer status;
}
