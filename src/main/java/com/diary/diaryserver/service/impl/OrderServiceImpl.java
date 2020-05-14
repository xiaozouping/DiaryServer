package com.diary.diaryserver.service.impl;

import com.diary.diaryserver.bean.Orders;
import com.diary.diaryserver.dao.OrderDao;
import com.diary.diaryserver.service.OrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;


    @Override
    public List<Orders> getOrderList(){
        return orderDao.selectOrderAll();
    }


    @Override
    public int addOrders(Orders orders){
        return orderDao.addOrder(orders);
    }

    @Override
    public int deliveryOrder(int orderId , Timestamp deliveryTime){
        System.out.println(deliveryTime);
        return orderDao.deliveryOrder(orderId,deliveryTime);
    }

    @Override
    public int cancelOrder(int orderId){
        return orderDao.cancelOrder(orderId);
    }

    @Override
    public List<Orders> SearchOrder(@Param("orderStatus") String orderStatus,
                                    @Param("orderNo") String orderNo,
                                    @Param("userPhone") String userPhone){
        return orderDao.SearchOrder(orderStatus,orderNo,userPhone);
    }

    @Override
    public List<Orders> findOrderByuserId(String userId){
        return orderDao.findOrderByuserId(userId);
    }

    @Override
    public int payOrder(int orderId){
        return orderDao.payOrder(orderId);
    }

    @Override
    public int receiveOrder(int orderId,Timestamp receiveTime){
        return orderDao.receiveOrder(orderId,receiveTime);
    }
}
