package com.diary.diaryserver.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Page<T> implements Serializable {
    List<T> pageList;   //数据
    int total;   //总记录数
    int currentPage;   //当前页
    int pageSize;    //每页显示记录数

    //总页数=总记录数/每页显示的记录数
    private int totalPage;
}
