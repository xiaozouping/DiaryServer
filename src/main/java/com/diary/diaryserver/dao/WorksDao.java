package com.diary.diaryserver.dao;

import com.diary.diaryserver.bean.Works;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface WorksDao {

    @Select("select * from works where userId = #{userId} order by works_createTime desc")
    List<Works> selectWorks(String userId);

    @Insert("insert into works(works_title,userId,works_createTime) values(#{works_title},#{userId},#{works_createTime})")
    int addWorks(Works works);

    @Select("select count(*) from works where works_title = #{works_title} and userId = #{userId}")
    int findTitle(String works_title,String userId);

    @Delete("delete from works where works_id=#{works_id}")
    int deleteWorks(int works_id);

    @Update("update works set works_title = #{works_title} where works_title = #{beworks_title} and userId = #{userId}")
    int updateWorks(String beworks_title,String works_title,String userId);



}
