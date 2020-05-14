package com.diary.diaryserver.service.impl;

import com.diary.diaryserver.bean.Chapter;
import com.diary.diaryserver.bean.Orders;
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

    @Override
    public int addChapters(Chapter chapter){
        return chapterDao.addChapters(chapter);
    }

    @Override
    public int findChpterTitle(String works_title,String userId,String chapter_title){
        return chapterDao.findchapterTitle(works_title,userId,chapter_title);
    }

    @Override
    public int updateChapters(Chapter chapter){
//        System.out.println(chapter);
        return chapterDao.updateChapters(chapter);
    }

    @Override
    public int deleteChapter(int chapter_id){
        return chapterDao.deleteChapter(chapter_id);
    }

    @Override
    public int updateWorksTitle(String beworks_title,String works_title,String userId){
        return chapterDao.updateWorksTitle(beworks_title,works_title,userId);
    }
}
