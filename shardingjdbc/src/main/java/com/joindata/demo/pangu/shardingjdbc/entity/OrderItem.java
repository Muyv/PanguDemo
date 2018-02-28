package com.joindata.demo.pangu.shardingjdbc.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class OrderItem
{
    private Long order_item_id;

    private String item_name;

    private Integer number;

    private BigDecimal money;

    private Date addtime;

    private Long order_id;

    private String remark;

    private Long user_id;

    private Integer version;

    private Long dishes_id;

    private String username;

    private String head_url;

    private Long menus_item_id;

    private Long dishes_sort_id;

    private Integer status;

    private String property_name;

    private BigDecimal price;

    private Long item_id;

    public Long getOrder_item_id()
    {
        return order_item_id;
    }

    public void setOrder_item_id(Long order_item_id)
    {
        this.order_item_id = order_item_id;
    }

    public String getItem_name()
    {
        return item_name;
    }

    public void setItem_name(String item_name)
    {
        this.item_name = item_name;
    }

    public Integer getNumber()
    {
        return number;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }

    public BigDecimal getMoney()
    {
        return money;
    }

    public void setMoney(BigDecimal money)
    {
        this.money = money;
    }

    public Date getAddtime()
    {
        return addtime;
    }

    public void setAddtime(Date addtime)
    {
        this.addtime = addtime;
    }

    public Long getOrder_id()
    {
        return order_id;
    }

    public void setOrder_id(Long order_id)
    {
        this.order_id = order_id;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public Long getUser_id()
    {
        return user_id;
    }

    public void setUser_id(Long user_id)
    {
        this.user_id = user_id;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public Long getDishes_id()
    {
        return dishes_id;
    }

    public void setDishes_id(Long dishes_id)
    {
        this.dishes_id = dishes_id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getHead_url()
    {
        return head_url;
    }

    public void setHead_url(String head_url)
    {
        this.head_url = head_url;
    }

    public Long getMenus_item_id()
    {
        return menus_item_id;
    }

    public void setMenus_item_id(Long menus_item_id)
    {
        this.menus_item_id = menus_item_id;
    }

    public Long getDishes_sort_id()
    {
        return dishes_sort_id;
    }

    public void setDishes_sort_id(Long dishes_sort_id)
    {
        this.dishes_sort_id = dishes_sort_id;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public String getProperty_name()
    {
        return property_name;
    }

    public void setProperty_name(String property_name)
    {
        this.property_name = property_name;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public Long getItem_id()
    {
        return item_id;
    }

    public void setItem_id(Long item_id)
    {
        this.item_id = item_id;
    }

}
