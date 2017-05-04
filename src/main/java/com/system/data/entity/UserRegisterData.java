package com.system.data.entity;

import com.system.core.util.FormConst;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by jx on 2017/4/24.
 */
public class UserRegisterData {
    @Getter @Setter
    @NotNull(message = "邮箱不可为空")
    @Pattern(regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", message = "邮箱格式不正确")
    private String email;

    @Getter @Setter
    @NotNull(message = "密码不可为空")
    @Size(max = 18, min = 8, message = "密码长度必须大于8位，小于18位")
    private String password;

    @Getter @Setter
    @NotNull(message = "密码不可为空")
    @Size(max = 18, min = 8, message = "密码长度必须大于8位，小于18位")
    private String confirmPassword;

    @Getter @Setter
    @NotNull(message = "用户名不可为空")
    @Size(max = 50, min = 5, message = "用户名长度错误")
    private String name;

    @Getter @Setter
    @NotNull(message = "地址不可为空")
    private String address;

    @Getter @Setter
    @NotNull(message = "性别不可为空")
    private String gender;

    @Getter @Setter
    @NotNull(message = "职业不可为空")
    private String profession;

    public User getUser() {
        int gender = (this.gender.equals("男")) ? 0 : 1;
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setAddress(this.address);
        user.setProfession(this.profession);
        user.setGender(gender);
        user.setStatus(FormConst.STATUS.CHECK.getValue());
        return user;
    }

    public boolean checkPasswordIfSame() {
        return this.password.equals(this.confirmPassword);
    }
}
