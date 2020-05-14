package com.diary.diaryserver.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class Admin {

    private Integer id;
    private String username;
    private String password;
    private String realname;
    private String phone;
    private String sex;
    private Date birth_day;
    private String admin_state;
    private String admin_rank;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp create_time;
}
