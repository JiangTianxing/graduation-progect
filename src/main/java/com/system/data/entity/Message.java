package com.system.data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by jx on 2017/4/30.
 */
public class Message {
    @Getter @Setter
    private Integer id;

    @NotNull(message = "标题未提交")
    @NotEmpty(message = "标题不可为空")
    @Getter @Setter
    private String title;

    @NotNull(message = "内容未提交")
    @NotEmpty(message = "内容不可为空")
    @Getter @Setter
    private String content;

    @Getter @Setter
    private Integer contentId;

    @Getter @Setter
    private Integer userId;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private int status;

    @Getter @Setter
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date savetime;

    @Getter @Setter
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatetime;
}
