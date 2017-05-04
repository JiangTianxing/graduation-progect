package com.system.data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Created by jx on 2017/4/30.
 */
public class Comment {
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private Integer messageId;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private Integer pid;

    @Getter @Setter
    private String content;

    @Getter @Setter
    private List<Comment> reply;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Getter @Setter
    private Date savetime;
}