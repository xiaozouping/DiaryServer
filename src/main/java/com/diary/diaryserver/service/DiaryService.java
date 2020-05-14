package com.diary.diaryserver.service;

import com.diary.diaryserver.bean.Diary;

import java.util.List;

public interface DiaryService {
    public List<Diary> findDiaryByUser(String userId);

    public int addDiary(Diary diary);

    public int updateDiary(Diary diary);

    public int deleteDiary(int diaryId);
}
