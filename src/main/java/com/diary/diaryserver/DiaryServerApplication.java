package com.diary.diaryserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.diary.diaryserver.dao")
//扫描的位置是dao包，该包下存放的都是与数据库交互的操作。

@SpringBootApplication
public class DiaryServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiaryServerApplication.class, args);
    }

}
