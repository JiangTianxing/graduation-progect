package com.system.data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by jx on 2017/4/26.
 */
public class Rule {
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    @NotNull(message = "标题未提交")
    @NotEmpty(message = "标题不可为空")
    private String title;

    @Getter @Setter
    @NotNull(message = "描述未提交")
    @NotEmpty(message = "描述不可为空")
    private String description;

    @Getter @Setter
    private String filename;

    @Getter @Setter
    private String path;

    @Getter @Setter
    private String md5;

    @Getter @Setter
    private Integer status;

    @Getter @Setter
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date savetime;

    @Getter @Setter
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatetime;
}
