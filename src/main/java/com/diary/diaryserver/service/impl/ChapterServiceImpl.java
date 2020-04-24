package com.diary.diaryserver.service.impl;

import com.diary.diaryserver.bean.Chapter;
import com.diary.diaryserver.dao.ChapterDao;
import com.diary.diaryserver.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    ChapterDao chapterDao;

    @Override
    public List<Chapter> findChapters(String userId,String works_title){
        return chapterDao.selectChapters(userId,works_title);
    }

}
