package com.diary.diaryserver.controller;


import com.diary.diaryserver.bean.Orders;
import com.diary.diaryserver.service.OrderService;
import com.diary.diaryserver.util.ExcelUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

//    @GetMapping("/getorder")
//    public List<Orders> getOrderList(){
//        return orderService.getOrderList();
//    }


    @PostMapping("/addorder")
    public int addOrders(Orders orders){
        orders.setCreateTime(new Timestamp(System.currentTimeMillis()));
//        System.out.println(orders.getOrderNo());
        return orderService.addOrders(orders);
    }


    @PutMapping("/deliveryorder/{orderId}")
    public int deliveryOrder(@PathVariable("orderId") Integer orderId){
        Timestamp deliveryTime = new Timestamp(System.currentTimeMillis());
//        System.out.println(deliveryTime);
        return orderService.deliveryOrder(orderId,deliveryTime);
    }

    @PutMapping("/cancelorder/{orderId}")
    public int cancelOrder(@PathVariable("orderId") Integer orderId){
//        System.out.println(deliveryTime);
        return orderService.cancelOrder(orderId);
    }

    @PostMapping("/deliveryAll")
    public int deliveryAll(@RequestParam("ids") String ids){
        int flag = 1;

        String [] arr = ids.split(",");
//        System.out.println(arr+"-1");
//        System.out.println(arr.length+"-22");
//        System.out.println(arr[0]+"-4");
//        System.out.println(arr[1]+"-5");

        Integer[] arrInt = new Integer[arr.length];
        for(int i = 0;i<arr.length;i++){
            arrInt[i] = Integer.parseInt(arr[i]);
        }

        for (int i=0;i<arr.length;i++){
            Timestamp deliveryTime = new Timestamp(System.currentTimeMillis());
            int num = orderService.deliveryOrder(arrInt[i],deliveryTime);
//            System.out.println(num);
            if (num==0){
                flag = 0;
            }
        }
        if (flag == 1){
            return 1;
        }
        else {
            return 0;
        }
    }


    @GetMapping("/getorder")
    public PageInfo GetOrderList(@RequestParam(value = "orderStatus",required = false) String orderStatus,
                                    @RequestParam(value = "orderNo",required = false) String orderNo,
                                    @RequestParam(value = "userPhone",required = false) String userPhone,
                                     @RequestParam(value = "currentPage",required = false) Integer currentPage,
                                     @RequestParam(value = "pageSize",required = false) Integer pageSize){
        int isNull = 0;

        if (orderStatus.equals("")){
            isNull+=1;
            orderStatus = null;
        }
        if (orderNo.equals("")){
            isNull+=1;
            orderNo = null;
        }
        if (userPhone.equals("")){
            isNull+=1;
            userPhone = null;
        }
        if (isNull==3){  //三个查询条件都为空的情况

            PageHelper.startPage(currentPage, pageSize);
            List<Orders> adminList =  orderService.getOrderList();
            PageInfo<Orders> pageInfo = new PageInfo<Orders>(adminList);
            return pageInfo;
        }
        else {
            PageHelper.startPage(currentPage, pageSize);
            List<Orders> adminList =  orderService.SearchOrder(orderStatus,orderNo,userPhone);
            PageInfo<Orders> pageInfo = new PageInfo<Orders>(adminList);
            return pageInfo;
        }
    }

    @GetMapping("/findorderByuserId/{userId}")
    public List<Orders> findOrderByuserId(@PathVariable("userId") String userId){
        return orderService.findOrderByuserId(userId);
    }

    @PutMapping("/payorder/{orderId}")
    public int payOrder(@PathVariable("orderId") Integer orderId) {
        return orderService.payOrder(orderId);
    }

    @PutMapping("/receiveorder/{orderId}")
    public int receiveOrder(@PathVariable("orderId") Integer orderId) {
        Timestamp receiveTime = new Timestamp(System.currentTimeMillis());
        return orderService.receiveOrder(orderId,receiveTime);
    }


}
