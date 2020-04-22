package com.diary.diaryserver;

import com.diary.diaryserver.bean.Admin;
//import com.diary.diaryserver.repository.AdminRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;

@SpringBootTest
class DiaryServerApplicationTests {

//    @Autowired
//    private AdminRepository adminRepository;
//
//    @Test
//    void contextLoads() {
//        PageRequest pageRequest = PageRequest.of(0,6);  //第一页，每页数据三条
//        Page<Admin> page = adminRepository.findAll(pageRequest);
//
//        int i = 0;
//    }
//
//    @Test
//    void save(){
//        Admin admin = new Admin();
//        admin.setUsername("张张");
////        int i=0;
//        Admin admin2 = adminRepository.save(admin);
//        System.out.println(admin2);
//
//    }
//
//
//    @Test
//    void findById(){
//        Admin admin3 = adminRepository.findById(2).get();
//        System.out.println(admin3);
//    }
//
//
//
//    @Test
////    @Query(value = "update admin set admin.admin_state = "1" where ")
//    void delete(){
//        Admin admin = new Admin();
//        admin.setId(7);
//        admin.setAdmin_state("1");
//        System.out.println(admin);
//
//    }



}
