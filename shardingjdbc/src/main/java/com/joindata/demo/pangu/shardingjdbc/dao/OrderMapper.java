package com.joindata.demo.pangu.shardingjdbc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.joindata.demo.pangu.shardingjdbc.entity.Order;

@Repository
public interface OrderMapper
{
    Order getOrderByStoreId(@Param("storeId") long storeId, @Param("orderId") long orderId);

    Order getOrderByUserId(@Param("userId") long userId, @Param("orderId") long orderId);

    List<Order> listStoreOrder(@Param("storeId") long storeId);

    List<Order> listUserOrder(@Param("userId") long userId);

    void insertOrder(Order order);

    void deleteOrder(@Param("storeId") long storeId, @Param("orderId") long orderId);

    void updateOrder(Order order);
}