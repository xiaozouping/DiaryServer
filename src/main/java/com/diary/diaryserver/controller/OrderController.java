package com.diary.diaryserver.controller;


import com.diary.diaryserver.bean.OrderMessage;
import com.diary.diaryserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ordermessage")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/getorder")
    public List<OrderMessage> getOrderList(){
        return orderService.getOrderList();
    }

}
