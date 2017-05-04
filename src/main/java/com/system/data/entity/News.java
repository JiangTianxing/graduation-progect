package com.system.data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.system.core.util.FormConst;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by jx on 2017/4/27.
 */
public class News {

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
    private int status;

    @Getter @Setter
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date savetime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Getter @Setter
    private Date updatetime;

    private Integer type;
    public Integer getType(){
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
        this.typeName = FormConst.NEWS_TYPE.getKey(type);
    }

    private String typeName;
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
        this.type = FormConst.NEWS_TYPE.getValue(typeName);
    }
}
