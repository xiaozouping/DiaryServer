package com.diary.diaryserver.controller;


import com.diary.diaryserver.bean.Admin;
import com.diary.diaryserver.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.sql.Date;
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
//        Admin admin = new Admin();
//        admin.setUsername(username);
//        admin.setPassword(password);
//        admin.setRealname(realname);
//        admin.setPhone(phone);
//        admin.setSex(sex);
//        admin.setBirth_day(birth_day);
//        admin.setAdmin_state(admin_state);
//        admin.setAdmin_rank(admin_rank);
//        admin.setCreate_time(create_time);

        return adminService.addAdmin(admin);
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

    @PutMapping("/updateById/{id}")
    public int updateById(@PathVariable("id") Integer id,@RequestBody Admin admin){

        return adminService.UpdateById(id,admin);
    }


//
//
//    //获取数据库分页数据
//    @GetMapping("/findAll/{page}/{size}")
//    public Page<Admin> findAll(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
//        PageRequest request = PageRequest.of(page,size);
//        return adminRepository.findAll(request);
//    }
//
//    @PostMapping("/save")
//    public String save(@RequestBody Admin admin){
//        Admin result = adminRepository.save(admin);
//        if (result!=null){
//            return "success";
//        }
//        else{
//            return "error";
//        }
//    }
//
//
//    @GetMapping("/findById/{id}")
//    public Admin findById(@PathVariable("id") Integer id){
//        return adminRepository.findById(id).get();
//    }
//
//
//
//    @PutMapping("/update")
//    public String update(@RequestBody Admin admin){
//        Admin result = adminRepository.save(admin);
//        if (result != null){
//            return "success";
//        }
//        else{
//            return "error";
//        }
//    }
//
//    @PutMapping("/deleteById/{id}")
//    public void delete(@PathVariable("id") Integer id){
//        Admin admin2 = new Admin();
//        admin2.setId(id);
//        admin2.setAdmin_state("1");
//    }
}
