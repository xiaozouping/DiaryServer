package com.diary.diaryserver.service;

import com.diary.diaryserver.bean.Admin;

import java.util.List;

public interface AdminService {

    int addAdmin(Admin admin);    //保存管理员

    List<Admin> getAdminList();   //获取管理员列表


    public int deleteAdmin(int id);  //删除

    public List<Admin> findById(int id);  //找到某条为id的数据

    public int UpdateById(int id,Admin admin);  //修改数据

//    List<Admin> pageAdminList(int currPage, int pageSize);
}


