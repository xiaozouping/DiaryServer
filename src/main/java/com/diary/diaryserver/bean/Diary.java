package com.diary.diaryserver.bean;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Diary {
    private Integer diaryId;
    private String userId;
    private String diary_title;
    private String diary_content;
    private String diary_location;
    private Timestamp diary_createTime;
}
