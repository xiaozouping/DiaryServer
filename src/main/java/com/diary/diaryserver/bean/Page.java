package com.diary.diaryserver.bean;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
//    数据
    List<T> data;

//    总页数
    int total;

//    当前页数
    int current;
}
