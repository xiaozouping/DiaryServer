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

    @Override
    public int addWorks(Works works){
        return worksDao.addWorks(works);
    }

    @Override
    public int findTitle(String works_title,String userId){
        return worksDao.findTitle(works_title,userId);
    }

    @Override
    public int deleteWorks(int works_id){
        return worksDao.deleteWorks(works_id);
    }

    @Override
    public int updateWorks(String beworks_title,String works_title,String userId){
        return worksDao.updateWorks(beworks_title,works_title,userId);
    }

}
