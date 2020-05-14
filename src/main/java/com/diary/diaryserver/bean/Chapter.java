package com.diary.diaryserver.bean;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class Chapter {
    private Integer chapter_id;

    @Excel(name = "文章标题", orderNum = "1")
    private String chapter_title;

    @Excel(name = "文章内容", orderNum = "2")
    private String chapter_content;

    @Excel(name = "作品名称", orderNum = "0")
    private String works_title;

    @Excel(name = "用户ID", orderNum = "4")
    private String userId;

    @Excel(name = "创建时间", orderNum = "3")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp chapter_createTime;
}
