package com.diary.diaryserver.controller;

import com.diary.diaryserver.bean.Works;
import com.diary.diaryserver.service.ChapterService;
import com.diary.diaryserver.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/works")
public class WorksController {

    @Autowired
    WorksService worksService;
    @Autowired
    ChapterService chapterService;

    @PostMapping("/getworks")
    public List<Works> findWorks(String userId){
//        System.out.println(userId);
        return worksService.findWorks(userId);
    }

    @PostMapping("/addworks")
    public int addWorks(Works works){
//        System.out.println(works.getWorks_title());
        String works_title = works.getWorks_title();
        String userId = works.getUserId();
        //判断数据库中是否已经存在该标题
        if (worksService.findTitle(works_title,userId)==0){
//            System.out.println("没有这个标题");
            works.setWorks_createTime(new Timestamp(System.currentTimeMillis()));
            return worksService.addWorks(works);
        }
        else {
//            System.out.println("有这个标题");
            return 2;
        }
    }

    @DeleteMapping("/deleteworks/{works_id}")
    public int deleteDiary(@PathVariable("works_id") int works_id){
        System.out.println(works_id);
        return worksService.deleteWorks(works_id);
    }

    @PostMapping("/updateworksTitle")
//    @RequestMapping("/updateworksTitle")
//    @ResponseBody
    public int updateWorksChapters(String beworks_title,String works_title,String userId){
        System.out.println(beworks_title);
        System.out.println(works_title);
        System.out.println(userId);
        int works = worksService.updateWorks(beworks_title,works_title,userId);
        int chapter = chapterService.updateWorksTitle(beworks_title,works_title,userId);

        System.out.println(works);
        System.out.println(chapter);
        if (works==1){
            return 1;
        }
        else {
            return 0;
        }
    }
}
