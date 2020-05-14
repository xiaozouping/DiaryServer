package com.diary.diaryserver.dao;

import com.diary.diaryserver.bean.Diary;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DiaryDao {

    @Select("select * from diary where userId = #{userId} order by diary_createTime desc")
    List<Diary> selectDiaryByUser(String userId);

    @Insert("insert into diary(userId,diary_title,diary_content,diary_location,diary_createTime,diary_images) values(#{userId},#{diary_title},#{diary_content},#{diary_location},#{diary_createTime},#{diary_images})")
    int insertDiary(Diary diary);

    @Update("update diary set diary_title=#{diary_title},diary_content=#{diary_content},diary_location=#{diary_location},diary_images=#{diary_images} where diaryId=#{diaryId}")
    int updateDiary(Diary diary);


    @Delete("delete from diary where diaryId=#{diaryId}")
    int deleteDiary(int diaryId);



}
