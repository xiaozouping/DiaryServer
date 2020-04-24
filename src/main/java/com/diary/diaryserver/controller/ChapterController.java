package com.diary.diaryserver.controller;


import com.diary.diaryserver.bean.Chapter;
import com.diary.diaryserver.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    ChapterService chapterService;

    @PostMapping("/getchapterlist")
    public List<Chapter> findChapterList(String userId, String works_title){
        return chapterService.findChapters(userId,works_title);
    }
}
