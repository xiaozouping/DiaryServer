package com.diary.diaryserver.service;

import com.diary.diaryserver.bean.Works;

import java.util.List;

public interface WorksService {

    public List<Works> findWorks(String userId);
}
