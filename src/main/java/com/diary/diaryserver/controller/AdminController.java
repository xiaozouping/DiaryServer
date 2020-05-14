package com.diary.diaryserver.controller;


import com.diary.diaryserver.bean.Admin;
import com.diary.diaryserver.bean.Page;
import com.diary.diaryserver.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/save")
    @ResponseBody
//    @PostMapping("/save")
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
    public List<Admin> getAdminList(){
        return adminService.getAdminList();
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

    @ResponseBody
    @RequestMapping("/login")
    public int loginAdmin(@RequestBody Admin admin, HttpSession session){
        System.out.println(admin);
        Admin a1 = adminService.loginAdmin(admin);
//        System.out.println(a1);
//        System.out.println(a1.getAdmin_state());
        if(a1==null){
            return 0;   //用户名或密码错误
        }
        else if (a1.getAdmin_state().equals("1")){
            return 2;   //帐号被删除，无效状态
        }
        else if (a1.getAdmin_state().equals("2")){
            return 3;   //帐号被冻结
        }
        else {
//            session.setAttribute("admin", a1);   //登录成功后将管理员放入session中，用于拦截
//            request.getSession().setAttribute("session_admin",a1);
            return 1;
        }
    }


    @PostMapping("/findpersonal")
    public Admin findByUsername(@RequestBody Admin admin){
        return adminService.findUsername(admin);
    }


    @GetMapping("/searchadmin")
    public List<Admin> SearchAdmin(@RequestParam(value = "username",required = false) String username,
                                   @RequestParam(value = "realname",required = false) String realname,
                                   @RequestParam(value = "admin_state",required = false) String admin_state,
                                   @RequestParam(value = "admin_rank",required = false) String admin_rank){
//        System.out.println(username);
//        System.out.println(realname);
//        System.out.println(admin_state);
//        System.out.println(admin_rank);
        return adminService.SearchAdmin(username,realname,admin_state,admin_rank);
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



    @GetMapping
    public Page<Admin> find(
            @RequestParam(name="p",defaultValue = "0") int page,
            @RequestParam(name="s",defaultValue = "20") int size
    ){

//		控制器调用业务逻辑
        return adminService.adminPage(page, size);
    }

//
//
//    //获取数据库分页数据
//    @GetMapping("/findAll/{page}/{size}")
//    public Page<Admin> findAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
//        PageRequest request = PageRequest.of(page,size);
//        return adminRepository.findAll(request);
//    }

}
