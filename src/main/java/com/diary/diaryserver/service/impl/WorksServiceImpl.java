package com.diary.diaryserver.service.impl;

import com.diary.diaryserver.bean.Works;
import com.diary.diaryserver.dao.WorksDao;
import com.diary.diaryserver.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorksServiceImpl implements WorksService {

    @Autowired
    WorksDao worksDao;

    @Override
    public List<Works> findWorks(String userId){
        return worksDao.selectWorks(userId);
    }
}
