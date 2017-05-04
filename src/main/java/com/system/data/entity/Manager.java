package com.system.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * Created by jx on 2017/4/24.
 */
public class Manager {
    @Getter @Setter
    @NotNull(message = "邮箱不可为空")
    @Email(message = "邮箱格式错误")
    private String email;

    @Getter @Setter
    @NotNull(message = "密码不可为空")
    private String password;

    @Getter @Setter
    private String name;
}
