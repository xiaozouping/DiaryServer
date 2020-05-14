package com.diary.diaryserver.dao;

import com.diary.diaryserver.bean.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;
import java.util.List;

public interface OrderDao {

    @Select("select * from orders order by createTime desc")
    List<Orders> selectOrderAll();   //查看所有订单

    @Insert("insert into orders(orderNo,userId,userName,userAddress,userPhone,works_title,orderStatus,totalPrice,goodsNum,deliveryPrice,deliveryName,worksPrice,createTime,worksPage) values (#{orderNo},#{userId},#{userName},#{userAddress},#{userPhone},#{works_title},#{orderStatus},#{totalPrice},#{goodsNum},#{deliveryPrice},#{deliveryName},#{worksPrice},#{createTime},#{worksPage})")
    int addOrder(Orders orders);   //添加订单

    @Update("update orders set orderStatus='1',deliveryTime =#{deliveryTime} where orderId=#{orderId}")
    int deliveryOrder(int orderId, Timestamp deliveryTime);    //单个发货操作

    @Update("update orders set orderStatus='3' where orderId=#{orderId}")
    int cancelOrder(int orderId);    //单个取消订单操作

    //条件查询
    @Select("<script> select * from orders" +
            "<where>"+
            "<if test='orderStatus != null'>and orderStatus = #{orderStatus} </if> "+
            " <if test='orderNo != null'>and orderNo like concat('%',#{orderNo},'%')</if> "+
            " <if test='userPhone != null'>and userPhone like concat('%',#{userPhone},'%')</if> order by createTime desc" +
            "</where>"+
            "</script>")
    List<Orders> SearchOrder (@Param("orderStatus") String orderStatus,
                             @Param("orderNo") String orderNo,
                             @Param("userPhone") String userPhone);

    //查看用户个人订单
    @Select("select * from orders where userId = #{userId} order by createTime desc")
    List<Orders> findOrderByuserId(String userId);

    //待付款订单支付
    @Update("update orders set orderStatus='0' where orderId=#{orderId}")
    int payOrder(int orderId);

    //签收订单
    @Update("update orders set orderStatus='2',receiveTime=#{receiveTime} where orderId=#{orderId}")
    int receiveOrder(int orderId ,Timestamp receiveTime);
}
