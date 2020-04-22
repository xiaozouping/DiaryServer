package com.diary.diaryserver.dao;

import com.diary.diaryserver.bean.OrderMessage;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDao {

    @Select("select * from ordermessage")
    List<OrderMessage> selectOrderAll();   //查看所有订单


}
