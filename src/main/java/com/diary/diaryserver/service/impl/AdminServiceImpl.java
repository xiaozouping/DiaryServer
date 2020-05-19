package com.diary.diaryserver.service.impl;

import com.diary.diaryserver.bean.Admin;
import com.diary.diaryserver.bean.Page;
import com.diary.diaryserver.dao.AdminDao;
import com.diary.diaryserver.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;
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

    @Override
    public int deleteAdmin(int id){
        return adminDao.deleteAdmin(id);
    }

    @Override
    public List<Admin> findById(int id){
        return adminDao.selectById(id);
    }

    @Override
    public int UpdateById(Admin admin){
        return adminDao.updateById(admin);
    }

    @Override
    public int UpdateByUsername(Admin admin){
        return adminDao.updateByUsername(admin);
    }

    @Override
    public Admin loginAdmin(Admin admin){
        return adminDao.loginAdmin(admin);
    }


    @Override
    public Admin findUsername(Admin admin){
        return adminDao.findUsername(admin);
    }

    @Override
    public List<Admin> SearchAdmin(@Param("username") String username,
                                   @Param("realname") String realname,
                                   @Param("admin_state") String admin_state,
                                   @Param("admin_rank") String admin_rank){
        return adminDao.SearchAdmin(username,realname,admin_state,admin_rank);
    }




//    @Override
//    public Page<Admin> adminPage(int page,int size) {
//
////		总记录数
//        int count=adminDao.count();
//
////		第page+1页的数据
//        List<Admin> list=adminDao.find(size, size*page );
//
////		向上取整计算出页数
//        int total=(int)Math.ceil(Double.valueOf(count)/size);
//
//        Page<Admin> adminPage=new Page<>();
//
//        adminPage.setData(list);
//        adminPage.setTotal(total);
//        adminPage.setCurrent(page);
//
//        return adminPage;
//    }

}
