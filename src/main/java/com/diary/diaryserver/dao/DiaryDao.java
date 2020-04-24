package com.diary.diaryserver.dao;

import com.diary.diaryserver.bean.Diary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DiaryDao {

    @Select("select * from diary where userId = #{userId} order by diary_createTime desc")
    List<Diary> selectDiaryByUser(String userId);

    @Insert("insert into diary(userId,diary_title,diary_content,diary_location,diary_createTime) values(#{userId},#{diary_title},#{diary_content},#{diary_location},#{diary_createTime})")
    int insertDiary(Diary diary);



}
