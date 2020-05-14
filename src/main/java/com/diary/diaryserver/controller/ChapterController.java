package com.diary.diaryserver.controller;

import com.diary.diaryserver.bean.Chapter;
import com.diary.diaryserver.service.ChapterService;
import com.diary.diaryserver.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
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

    @PostMapping("/addchapter")
    public int addChapter(Chapter chapter){
        String chapter_title = chapter.getChapter_title();
        String userId = chapter.getUserId();
        String works_title = chapter.getWorks_title();

        if(chapterService.findChpterTitle(works_title,userId,chapter_title)==0){
            chapter.setChapter_createTime(new Timestamp(System.currentTimeMillis()));
            return chapterService.addChapters(chapter);
        }
        else {
            return 2;
        }
    }


    @PutMapping("/updatechapters")
    public int updateChapters(@RequestBody Chapter chapter){
//        System.out.println(chapter);
        return chapterService.updateChapters(chapter);
    }

    @DeleteMapping("/deletechapter/{chapter_id}")
    public int deleteChapter(@PathVariable("chapter_id") int chapter_id){
//        System.out.println(chapter_id);
        return chapterService.deleteChapter(chapter_id);
    }


    @GetMapping("/exportExcel/{userId}/{works_title}")
    public void export(@PathVariable("userId") String userId,
                       @PathVariable("works_title") String works_title,
                       HttpServletResponse response){
//        System.out.println(userId);
//        System.out.println(works_title);

        List<Chapter> chapterList = chapterService.findChapters(userId,works_title);
//        System.out.println(chapterList);
        //导出操作
        ExcelUtil.exportExcel(chapterList,"作品内容","作品内容",Chapter.class,"《"+works_title+"》.xls",response);
    }

}
