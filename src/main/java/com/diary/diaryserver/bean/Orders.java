package com.diary.diaryserver.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Orders {
    private Integer orderId;
    private String orderNo;
    private String userId;
    private String userName;
    private String userAddress;
    private String userPhone;
    private String works_title;
    private String orderStatus;
    private Integer totalPrice;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp deliveryTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Timestamp receiveTime;

    private Integer goodsNum;
    private Integer deliveryPrice;
    private String deliveryName;
    private Integer worksPrice;
    private Integer worksPage;
}
