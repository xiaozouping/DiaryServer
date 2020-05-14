package com.diary.diaryserver.service.impl;

import com.diary.diaryserver.bean.Diary;
import com.diary.diaryserver.dao.DiaryDao;
import com.diary.diaryserver.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    DiaryDao diaryDao;

    @Override
    public List<Diary> findDiaryByUser(String userId){
        return diaryDao.selectDiaryByUser(userId);
    }

    @Override
    public int addDiary(Diary diary){
        return diaryDao.insertDiary(diary);
    }

    @Override
    public int updateDiary(Diary diary){
        return diaryDao.updateDiary(diary);
    }

    @Override
    public int deleteDiary(int diaryId){
        return diaryDao.deleteDiary(diaryId);
    }

}
