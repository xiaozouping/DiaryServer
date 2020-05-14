package com.diary.diaryserver.service;

import com.diary.diaryserver.bean.Chapter;
import com.diary.diaryserver.bean.Orders;

import java.util.List;

public interface ChapterService {
    public List<Chapter> findChapters(String userId, String works_title);

    public int addChapters(Chapter chapter);

    public int findChpterTitle(String works_title,String userId,String chapter_title);

    public int updateChapters(Chapter chapter);

    public int deleteChapter(int chapter_id);

    public int updateWorksTitle(String beworks_title,String works_title,String userId);

}
