package com.diary.diaryserver.service.impl;

import com.diary.diaryserver.bean.OrderMessage;
import com.diary.diaryserver.dao.OrderDao;
import com.diary.diaryserver.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;


    @Override
    public List<OrderMessage> getOrderList(){
        return orderDao.selectOrderAll();
    }
}
