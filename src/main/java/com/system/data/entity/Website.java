package com.system.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by jx on 2017/4/25.
 */
public class Website {

    @Getter @Setter
    @SafeHtml
    @NotNull(message = "电话未提交")
    @Size(min = 6, max = 11, message = "电话格式不正确")
    private String phone;

    @Getter @Setter
    @SafeHtml
    @NotNull(message = "地址未提交")
    @NotEmpty(message = "地址不可为空")
    private String address;

    @Getter @Setter
    @SafeHtml
    @NotNull(message = "建站初衷未提交")
    @NotEmpty(message = "建站初衷不可为空")
    private String thought;

    @Getter @Setter
    @SafeHtml
    @NotNull(message = "版权信息为提交")
    @NotEmpty(message = "版权信息不可为空")
    private String copyright;

    @Getter @Setter
    @SafeHtml
    @NotNull(message = "邮政编码未提交")
    @NotEmpty(message = "邮政编码不可为空")
    @Size(max = 6, min = 6, message = "邮政编码格式不正确")
    private String code;
}
