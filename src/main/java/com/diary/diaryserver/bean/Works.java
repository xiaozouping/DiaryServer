package com.diary.diaryserver.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class Works {
    private Integer works_id;
    private String works_title;
    private String userId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp works_createTime;

}
