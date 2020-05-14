package com.diary.diaryserver.service;

import com.diary.diaryserver.bean.Orders;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface OrderService {
    public List<Orders> getOrderList();

    public int addOrders(Orders orders);

    public int deliveryOrder(int orderId , Timestamp deliveryTime);

    public int cancelOrder(int orderId);

    public List<Orders> SearchOrder(@Param("orderStatus") String orderStatus,
                                    @Param("orderNo") String orderNo,
                                    @Param("userPhone") String userPhone);

    public List<Orders> findOrderByuserId(String userId);

    public int payOrder(int orderId);

    public int receiveOrder(int orderId,Timestamp receiveTime);
}
