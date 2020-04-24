package com.diary.diaryserver.controller;

import com.diary.diaryserver.bean.Diary;
import com.diary.diaryserver.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/diary")
public class DiaryController {
    @Autowired
    DiaryService diaryService;

    @PostMapping("/getdiaryList")
    public List<Diary> findDiaruList(String userId){
//        System.out.println(userId);
        return diaryService.findDiaryByUser(userId);
    }


    @PostMapping("/adddiary")
    public int addDiary(Diary diary){
        return diaryService.addDiary(diary);
    }

}
