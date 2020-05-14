package com.diary.diaryserver.service;

import com.diary.diaryserver.bean.Admin;
import com.diary.diaryserver.bean.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {

    int addAdmin(Admin admin);    //保存管理员

    List<Admin> getAdminList();   //获取管理员列表


    public int deleteAdmin(int id);  //删除

    public List<Admin> findById(int id);  //找到某条为id的数据

    public int UpdateById(Admin admin);  //修改数据

    public int UpdateByUsername(Admin admin);  //修改密码

    public Admin loginAdmin(Admin admin);

    public Admin findUsername(Admin admin);

    public List<Admin> SearchAdmin(@Param("username") String username,
                                   @Param("realname") String realname,
                                   @Param("admin_state") String admin_state,
                                   @Param("admin_rank") String admin_rank);

//    List<Admin> pageAdminList(int currPage, int pageSize);

    public Page<Admin> adminPage(int page, int size);
}


