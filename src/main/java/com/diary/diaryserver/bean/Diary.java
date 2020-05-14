package com.diary.diaryserver.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class Diary {
    private Integer diaryId;
    private String userId;
    private String diary_title;
    private String diary_content;
    private String diary_location;
    private String diary_images;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp diary_createTime;
}
