package com.diary.diaryserver.service;

import com.diary.diaryserver.bean.Chapter;

import java.util.List;

public interface ChapterService {
    public List<Chapter> findChapters(String userId, String works_title);
}
