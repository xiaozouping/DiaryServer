package com.diary.diaryserver.service;

import com.diary.diaryserver.bean.Works;

import java.util.List;

public interface WorksService {

    public List<Works> findWorks(String userId);

    public int addWorks(Works works);

    public int findTitle(String works_title,String userId);

    public int deleteWorks(int works_id);

    public int updateWorks(String beworks_title,String works_title,String userId);
}
