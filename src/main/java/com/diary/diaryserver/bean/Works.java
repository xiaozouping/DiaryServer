package com.diary.diaryserver.bean;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Works {
    private Integer works_id;
    private String works_title;
    private String userId;
    private Integer chapterCount;
    private Timestamp works_createTime;

}
