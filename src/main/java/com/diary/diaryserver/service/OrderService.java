package com.diary.diaryserver.service;

import com.diary.diaryserver.bean.OrderMessage;

import java.util.List;

public interface OrderService {
    public List<OrderMessage> getOrderList();
}
