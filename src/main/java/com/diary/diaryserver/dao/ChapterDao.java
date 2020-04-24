package com.diary.diaryserver.dao;

import com.diary.diaryserver.bean.Chapter;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ChapterDao {

    @Select("select * from chapter where userId = #{userId} and works_title = #{works_title} order by chapter_createTime desc")
    List<Chapter> selectChapters(String userId,String works_title);



}
