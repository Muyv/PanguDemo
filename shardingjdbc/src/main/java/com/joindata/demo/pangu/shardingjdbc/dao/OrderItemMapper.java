package com.joindata.demo.pangu.shardingjdbc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.joindata.demo.pangu.shardingjdbc.entity.OrderItem;

@Repository
public interface OrderItemMapper
{
    List<OrderItem> getOrderItemByOrderId(@Param("orderId") long orderId);

    OrderItem getOrderItem(@Param("orderId") long orderId, @Param("orderItemId") long orderItemId);

    void insertOrderItem(OrderItem orderItem);

    void deleteOrderItemByOrderId(@Param("orderId") long orderId);

    void deleteOrderItem(@Param("orderId") long orderId, @Param("orderItemId") long orderItemId);

    void updateOrderItem(OrderItem orderItem);
}