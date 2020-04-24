package com.diary.diaryserver.dao;

import com.diary.diaryserver.bean.Works;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WorksDao {

    @Select("select * from works where userId = #{userId} order by works_createTime desc")
    List<Works> selectWorks(String userId);




}
