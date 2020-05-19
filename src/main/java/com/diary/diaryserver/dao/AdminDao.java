package com.diary.diaryserver.dao;

import com.diary.diaryserver.bean.Admin;
import com.diary.diaryserver.bean.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminDao {
    @Insert("insert into admin(username,password,realname,phone,sex,admin_state,admin_rank,birth_day,create_time) values (#{username},#{password},#{realname},#{phone},#{sex},#{admin_state},#{admin_rank},#{birth_day},#{create_time})")
    int insertAdmin(Admin admin);      //添加管理员

    @Select("select * from admin order by create_time desc")
    List<Admin> selectAdminAll();     //查看管理员全部数据

//    @Select("select * from admin order by create_time desc")
//    Page selectAdminAll1();     //查看管理员全部数据

    @Update("update admin set admin_state = '1' where id = #{id}")
    int deleteAdmin(int id);    //将管理员帐号变成无效,物理删除

    @Select("select * from admin where id = #{id}")
    List<Admin> selectById(int id);     //查看某条数据

    @Update("update admin set password=#{password},realname=#{realname},phone=#{phone},admin_state=#{admin_state},admin_rank=#{admin_rank} where id=#{id}")
    int updateById(Admin admin);

    @Update("update admin set password=#{password} where username=#{username}")
    int updateByUsername(Admin admin);

    @Select("select * from admin where username=#{username} and password=#{password}")
    Admin loginAdmin(Admin admin);
//    List<Admin> queryStudentsBySql(Admin<String,Object> data);

    @Select("select * from admin where username = #{username}")
    Admin findUsername(Admin admin);

    //条件查询
    @Select("<script> select * from admin" +
            "<where>"+
            "<if test='username != null'>and username like concat('%',#{username},'%') </if> "+
            " <if test='realname != null'>and realname like concat('%',#{realname},'%') </if> "+
            " <if test='admin_state != null'>and admin_state = #{admin_state}</if> "+
            " <if test='admin_rank != null'>and admin_rank = #{admin_rank}</if> order by create_time desc" +
            "</where>"+
            "</script>")
    List<Admin> SearchAdmin (@Param("username") String username,
                               @Param("realname") String realname,
                               @Param("admin_state") String admin_state,
                               @Param("admin_rank") String admin_rank);




    //分页测试
/**
 * 分页查询
 *
 * @param limit 记录行数
 * @param offset 偏移量
 * @return
*/
    @Select("select * from admin order by create_time desc limit #{limit} offset #{offset}")
    List<Admin> find(@Param("limit") int limit,@Param("offset") int offset);

    @Select("select count(id) from admin" )
    int count();


}
