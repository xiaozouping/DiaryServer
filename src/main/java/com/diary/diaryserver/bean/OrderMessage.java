package com.diary.diaryserver.bean;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderMessage {
    private Integer orderId;
    private String orderNo;
    private String userId;
    private String userName;
    private String userAddress;
    private String userPhone;
    private String goodsName;
    private String orderStatus;
    private Integer totalPrice;
    private String orderRemarks;
    private Timestamp createTime;
    private Timestamp deliveryTime;
    private Timestamp receiveTime;
    private Integer goodsNumber;
}
