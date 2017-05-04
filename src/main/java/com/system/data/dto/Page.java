package com.system.data.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections.map.HashedMap;

import java.util.*;

/**
 * Created by jx on 2017/4/29.
 */
public class Page<T> {

    //当前页数
    @Getter @Setter
    private int current;
    //当前页显示条数
    @Getter @Setter
    private int size;
    //共计页数
    @Getter @Setter
    private int total;
    //当前页信息
    @Getter @Setter
    private List<T> items;
}