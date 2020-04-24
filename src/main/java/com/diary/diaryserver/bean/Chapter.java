package com.diary.diaryserver.bean;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Chapter {
    private Integer chapter_id;
    private String chapter_title;
    private String chapter_content;
    private String works_title;
    private String userId;
    private Timestamp chapter_createTime;
}
