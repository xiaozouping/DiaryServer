package com.diary.diaryserver.bean;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

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
    private Timestamp create_time;

}
