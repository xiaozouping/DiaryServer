package com.diary.diaryserver.controller;


import com.diary.diaryserver.bean.Admin;
import com.diary.diaryserver.bean.Page;
import com.diary.diaryserver.service.AdminService;
import com.diary.diaryserver.util.Response;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @ResponseBody
    @RequestMapping("/login")
    public Response loginAdmin(@RequestBody Admin admin, HttpSession session){
//        System.out.println(admin);
        Admin a1 = adminService.loginAdmin(admin);
//        System.out.println(a1);
//        System.out.println(a1.getAdmin_state());
        if(a1==null){
            return Response.no("0");
        }
        else if (a1.getAdmin_state().equals("1")){
            return Response.no("1");
        }
        else if (a1.getAdmin_state().equals("2")){
            return Response.no("2");
        }
        else {
            session.setAttribute("admin", a1);   //登录成功后将管理员放入session中，用于拦截
            return Response.yes(a1,"登录成功");
        }
    }

    @RequestMapping("/save")
    @ResponseBody
    public int addAdmin(@RequestBody Admin admin){
        System.out.println(admin);
        Admin isUsername = adminService.findUsername(admin);
        System.out.println(isUsername);
        if (isUsername==null){
            //将创建时间变为当前时间
            admin.setCreate_time(new Timestamp(System.currentTimeMillis()));
            return adminService.addAdmin(admin);
        }
        else {  //该用户名已存在
            return 0;
        }
    }

    @GetMapping("/getadmin")
    public PageInfo GetAdminList(@RequestParam(value = "username",required = false) String username,
                                   @RequestParam(value = "realname",required = false) String realname,
                                   @RequestParam(value = "admin_state",required = false) String admin_state,
                                   @RequestParam(value = "admin_rank",required = false) String admin_rank,
                                   @RequestParam(value = "currentPage",required = false) Integer currentPage,
                                   @RequestParam(value = "pageSize",required = false) Integer pageSize
                                   ){
//        System.out.println(username);
//        System.out.println(realname);
//        System.out.println(admin_state);
//        System.out.println(admin_rank);
//        System.out.println(currentPage);
//        System.out.println(pageSize+"--");
        int isNull = 0;

        if (username.equals("")){
            isNull+=1;
            username = null;
        }
        if (realname.equals("")){
            isNull+=1;
            realname = null;
        }
        if (admin_state.equals("")){
            isNull+=1;
            admin_state = null;
        }
        if (admin_rank.equals("")){
            isNull+=1;
            admin_rank = null;
        }


        if (isNull==4){  //四个查询条件都为空的情况
            PageHelper.startPage(currentPage, pageSize);
            List<Admin> adminList =  adminService.getAdminList();
            PageInfo<Admin> pageInfo = new PageInfo<Admin>(adminList);
            return pageInfo;
        }
        else {
            PageHelper.startPage(currentPage, pageSize);
            List<Admin> adminList = adminService.SearchAdmin(username,realname,admin_state,admin_rank);
            PageInfo<Admin> pageInfo = new PageInfo<Admin>(adminList);
            return pageInfo;
        }

    }

    @PutMapping("/deleteById/{id}")
    public int deleteAdmin(@PathVariable("id") Integer id){
        return adminService.deleteAdmin(id);
    }

    @GetMapping("/findById/{id}")
    public List<Admin> findById(@PathVariable("id") Integer id){
        return adminService.findById(id);
    }

    @PutMapping("/updateById")
    public int updateById(@RequestBody Admin admin){
        return adminService.UpdateById(admin);
    }

    @PutMapping("/updateByUsername")
    public int updateByUsername(@RequestBody Admin admin){
        return adminService.UpdateByUsername(admin);
    }

    @PostMapping("/findpersonal")
    public Admin findByUsername(@RequestBody Admin admin){
        return adminService.findUsername(admin);
    }

    @PostMapping("/deleteAll")
    public int deleteAll(@RequestParam("ids") String ids){
//        System.out.println(ids+"0");
        int flag = 1;

        String [] arr = ids.split(",");
//        System.out.println(arr+"-1");
//        System.out.println(arr.length+"-22");
//        System.out.println(arr[0]+"-4");
//        System.out.println(arr[1]+"-5");

        Integer[] arrInt = new Integer[arr.length];
        for(int i = 0;i<arr.length;i++){
            arrInt[i] = Integer.parseInt(arr[i]);
        }

        for (int i=0;i<arr.length;i++){
            int num = adminService.deleteAdmin(arrInt[i]);
//            System.out.println(num);
            if (num==0){
                flag = 0;
            }
        }
        if (flag == 1){
            return 1;
        }
        else {
            return 0;
        }
    }

}
