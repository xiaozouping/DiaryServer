package com.diary.diaryserver.controller;

import com.diary.diaryserver.bean.Works;
import com.diary.diaryserver.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/works")
public class WorksController {

    @Autowired
    WorksService worksService;

    @PostMapping("/getworks")
    public List<Works> findWorks(String userId){
//        System.out.println(userId);
        return worksService.findWorks(userId);
    }
}
