package com.joindata.demo.pangu.shardingjdbc.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joindata.demo.pangu.shardingjdbc.dao.OrderItemMapper;
import com.joindata.demo.pangu.shardingjdbc.dao.OrderMapper;
import com.joindata.demo.pangu.shardingjdbc.entity.Order;
import com.joindata.demo.pangu.shardingjdbc.entity.OrderItem;
import com.joindata.inf.common.support.idgen.annotation.Sequence;
import com.joindata.inf.common.support.idgen.component.sequence.impl.DefaultSequence;
import com.joindata.inf.common.support.idgen.component.sequence.impl.TimestampPrefixSequence;
import com.joindata.inf.common.util.basic.CollectionUtil;

import io.swagger.annotations.ApiOperation;

/**
 * 说明：<br />
 * - 查询时必须传 storeId 或 userId 中的一个，如果都传会返回两个相同记录 </br >
 * - 插入、更新时 storeId 和 userId 都必须传，当然 orderId 也是必须的
 * 
 * @author <a href="mailto:songxiang@joindata.com">宋翔</a>
 * @date Apr 5, 2017 3:46:31 PM
 */
@RestController
@RequestMapping
public class OrderController
{
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    /** 5位日期戳+2位命名空间前缀+序列值 */
    @Sequence("ORDER_ID")
    private TimestampPrefixSequence orderSeq;

    /** 纯粹序列值 */
    @Sequence("ORDER_ITEM_ID")
    private DefaultSequence orderItemSeq;

    @ApiOperation("查询店铺下的订单，包括明细")
    @GetMapping("/store/{storeId}/order/{orderId}")
    public Order getOrderByStore(@PathVariable long storeId, @PathVariable long orderId)
    {
        Order order = orderMapper.getOrderByStoreId(storeId, orderId);
        if(order != null)
        {
            order.setItemList(orderItemMapper.getOrderItemByOrderId(order.getOrder_id()));
        }

        return order;
    }

    @ApiOperation("查询用户下的订单，包括明细")
    @GetMapping("/user/{userId}/order/{orderId}")
    public Order getOrderByUser(@PathVariable long userId, @PathVariable long orderId)
    {
        Order order = orderMapper.getOrderByStoreId(userId, orderId);
        if(order != null)
        {
            order.setItemList(orderItemMapper.getOrderItemByOrderId(order.getOrder_id()));
        }
        return order;
    }

    @ApiOperation("列出店铺下的订单，包括明细")
    @GetMapping("/store/{storeId}/order/")
    public List<Order> listStoreOrder(@PathVariable long storeId)
    {
        List<Order> orderList = orderMapper.listStoreOrder(storeId);

        if(!CollectionUtil.isNullOrEmpty(orderList))
        {
            for(Order order: orderList)
            {
                if(order != null)
                {
                    order.setItemList(orderItemMapper.getOrderItemByOrderId(order.getOrder_id()));
                }
            }
        }

        return orderList;
    }

    @ApiOperation("列出用户下的订单，包括明细")
    @GetMapping("/user/{userId}/order/")
    public List<Order> listUserOrder(@PathVariable long userId)
    {
        List<Order> orderList = orderMapper.listStoreOrder(userId);

        if(!CollectionUtil.isNullOrEmpty(orderList))
        {
            for(Order order: orderList)
            {
                if(order != null)
                {
                    order.setItemList(orderItemMapper.getOrderItemByOrderId(order.getOrder_id()));
                }
            }
        }

        return orderList;
    }

    @ApiOperation("创建订单（通过店铺 ID），包括明细")
    @PostMapping("/store/{storeId}/order/")
    @Transactional(rollbackFor = RuntimeException.class)
    public Long createOrder(@PathVariable long storeId, @RequestBody Order order)
    {
        order.setOrder_id(orderSeq.next());
        order.setStore_id(storeId);
        orderMapper.insertOrder(order);

        if(!CollectionUtil.isNullOrEmpty(order.getItemList()))
        {
            for(OrderItem item: order.getItemList())
            {
                item.setOrder_item_id(orderItemSeq.next());
                item.setOrder_id(order.getOrder_id());
                item.setItem_name(order.getOrder_id() + " 的ITEM");
                orderItemMapper.insertOrderItem(item);
            }
        }

        return order.getOrder_id();
    }

    @ApiOperation("修改订单（通过店铺 ID），不包括明细")
    @PutMapping("/store/{storeId}/order/{orderId}")
    public void modifyOrder(@PathVariable long storeId, @PathVariable long orderId, @RequestBody Order order)
    {
        order.setStore_id(storeId);
        order.setOrder_id(orderId);
        orderMapper.updateOrder(order);
    }

    @ApiOperation("删除订单（通过店铺 ID），并删除相关明细")
    @DeleteMapping("/store/{storeId}/order/{orderId}")
    public void removeOrder(@PathVariable long storeId, @PathVariable long orderId)
    {
        orderMapper.deleteOrder(storeId, orderId);
        orderItemMapper.deleteOrderItemByOrderId(orderId);
    }

    @ApiOperation("修改订单明细（通过店铺 ID）")
    @PutMapping("/store/{storeId}/order/{orderId}/{orderItemId}")
    public void modifyOrderItem(@PathVariable long storeId, @PathVariable long orderId, @PathVariable long orderItemId, @RequestBody OrderItem orderItem)
    {
        orderItem.setOrder_id(orderId);
        orderItem.setOrder_item_id(orderItemId);
        orderItemMapper.updateOrderItem(orderItem);
    }
}
