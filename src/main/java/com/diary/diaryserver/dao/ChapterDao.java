package com.diary.diaryserver.dao;

import com.diary.diaryserver.bean.Chapter;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ChapterDao {

    //查询某个人某部作品的文章
    @Select("select * from chapter where userId = #{userId} and works_title = #{works_title} order by chapter_createTime desc")
    List<Chapter> selectChapters(String userId,String works_title);

    @Insert("insert into chapter(chapter_title,chapter_content,works_title,userId,chapter_createTime) values(#{chapter_title},#{chapter_content},#{works_title},#{userId},#{chapter_createTime})")
    int addChapters(Chapter chapter);

    @Select("select count(*) from chapter where works_title = #{works_title} and userId = #{userId} and chapter_title = #{chapter_title}")
    int findchapterTitle(String works_title,String userId,String chapter_title);

    @Update("update chapter set chapter_title=#{chapter_title},chapter_content=#{chapter_content} where chapter_id = #{chapter_id}")
    int updateChapters(Chapter chapter);

    @Delete("delete from chapter where chapter_id=#{chapter_id}")
    int deleteChapter(int chapter_id);

    @Update("update chapter set works_title = #{works_title} where works_title = #{beworks_title} and userId = #{userId}")
    int updateWorksTitle(String beworks_title,String works_title,String userId);
}
