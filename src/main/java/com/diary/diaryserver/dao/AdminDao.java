package com.diary.diaryserver.dao;

import com.diary.diaryserver.bean.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminDao {
    @Insert("insert into admin(username,password,realname,phone,sex,admin_state,admin_rank,birth_day,create_time) values (#{username},#{password},#{realname},#{phone},#{sex},#{admin_state},#{admin_rank},#{birth_day},#{create_time})")
    int insertAdmin(Admin admin);      //添加管理员


    @Select("select * from admin")
    List<Admin> selectAdminAll();     //查看管理员全部数据

    @Update("update admin set admin_state = '1' where id = #{id}")
    int deleteAdmin(int id);    //将管理员帐号变成无效,物理删除

    @Select("select * from admin where id = #{id}")
    List<Admin> selectById(int id);     //查看某条数据

    @Update("update admin set password=#{param2.password},phone=#{param2.phone},admin_state=#{param2.admin_state},admin_rank=#{param2.admin_rank} where id=#{param1}")
    int updateById(int id,Admin admin);


//    List<Admin> queryStudentsBySql(Admin<String,Object> data);
}
