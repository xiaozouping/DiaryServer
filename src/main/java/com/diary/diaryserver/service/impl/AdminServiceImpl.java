package com.diary.diaryserver.service.impl;

import com.diary.diaryserver.bean.Admin;
import com.diary.diaryserver.dao.AdminDao;
import com.diary.diaryserver.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminDao adminDao;

    @Override
    public int addAdmin(Admin admin){
        return adminDao.insertAdmin(admin);
    }

    @Override
    public List<Admin> getAdminList(){
        return adminDao.selectAdminAll();
    }

    public int deleteAdmin(int id){
        return adminDao.deleteAdmin(id);
    }


    public List<Admin> findById(int id){
        return adminDao.selectById(id);
    }

    public int UpdateById(int id,Admin admin){
        return adminDao.updateById(id,admin);
    }

//    public List<Admin> pageAdminList(int currPage, int pageSize){
//        //查询全部数据
//        List<Admin> adminList = adminDao.selectAdminAll();
//        //从第几条数据开始
//        int firstIndex = (currPage - 1) * pageSize;
//        //到第几条数据结束
//        int lastIndex = currPage * pageSize;
//        return Admin.subList(firstIndex, lastIndex); //直接在list中截取
//    }
}
