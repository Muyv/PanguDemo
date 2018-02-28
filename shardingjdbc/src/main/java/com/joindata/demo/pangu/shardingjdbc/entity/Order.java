package com.joindata.demo.pangu.shardingjdbc.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class Order
{
    private Long order_id;

    private String order_no;

    private Long store_id;

    private String store_name;

    private Integer pay_type;

    private Integer order_type;

    private String phone;

    private Date addtime;

    private String people_number;

    private BigDecimal totelprice;

    private Long user_id;

    private Long table_id;

    private Long config_user_id;

    private Date config_time;

    private Integer version;

    private Integer status;

    private Integer update_time;

    private Integer remark;

    private Integer channel;

    private String username;

    private String head_url;

    private String table_name;

    private Long total_weight;

    private String store_tel;

    private Long pay_config_user_id;

    private Date pay_config_time;

    private Integer is_invoice;

    private String invoice_header;

    private Integer is_read;

    private Integer invoice_type;

    private Integer attribute;

    private String email;

    private Integer evaluate_status;

    private Long parent_id;

    private Integer drink_type;

    private Integer activity_type;

    private BigDecimal paid_money;

    private BigDecimal no_discount_money;

    private BigDecimal paid_discount_money;

    private BigDecimal order_discount;

    private String activity_name;

    private String eat_number;

    private List<OrderItem> itemList;

    public Long getOrder_id()
    {
        return order_id;
    }

    public void setOrder_id(Long order_id)
    {
        this.order_id = order_id;
    }

    public String getOrder_no()
    {
        return order_no;
    }

    public void setOrder_no(String order_no)
    {
        this.order_no = order_no;
    }

    public Long getStore_id()
    {
        return store_id;
    }

    public void setStore_id(Long store_id)
    {
        this.store_id = store_id;
    }

    public String getStore_name()
    {
        return store_name;
    }

    public void setStore_name(String store_name)
    {
        this.store_name = store_name;
    }

    public Integer getPay_type()
    {
        return pay_type;
    }

    public void setPay_type(Integer pay_type)
    {
        this.pay_type = pay_type;
    }

    public Integer getOrder_type()
    {
        return order_type;
    }

    public void setOrder_type(Integer order_type)
    {
        this.order_type = order_type;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public Date getAddtime()
    {
        return addtime;
    }

    public void setAddtime(Date addtime)
    {
        this.addtime = addtime;
    }

    public String getPeople_number()
    {
        return people_number;
    }

    public void setPeople_number(String people_number)
    {
        this.people_number = people_number;
    }

    public BigDecimal getTotelprice()
    {
        return totelprice;
    }

    public void setTotelprice(BigDecimal totelprice)
    {
        this.totelprice = totelprice;
    }

    public Long getUser_id()
    {
        return user_id;
    }

    public void setUser_id(Long user_id)
    {
        this.user_id = user_id;
    }

    public Long getTable_id()
    {
        return table_id;
    }

    public void setTable_id(Long table_id)
    {
        this.table_id = table_id;
    }

    public Long getConfig_user_id()
    {
        return config_user_id;
    }

    public void setConfig_user_id(Long config_user_id)
    {
        this.config_user_id = config_user_id;
    }

    public Date getConfig_time()
    {
        return config_time;
    }

    public void setConfig_time(Date config_time)
    {
        this.config_time = config_time;
    }

    public Integer getVersion()
    {
        return version;
    }

    public void setVersion(Integer version)
    {
        this.version = version;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getUpdate_time()
    {
        return update_time;
    }

    public void setUpdate_time(Integer update_time)
    {
        this.update_time = update_time;
    }

    public Integer getRemark()
    {
        return remark;
    }

    public void setRemark(Integer remark)
    {
        this.remark = remark;
    }

    public Integer getChannel()
    {
        return channel;
    }

    public void setChannel(Integer channel)
    {
        this.channel = channel;
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

    public String getTable_name()
    {
        return table_name;
    }

    public void setTable_name(String table_name)
    {
        this.table_name = table_name;
    }

    public Long getTotal_weight()
    {
        return total_weight;
    }

    public void setTotal_weight(Long total_weight)
    {
        this.total_weight = total_weight;
    }

    public String getStore_tel()
    {
        return store_tel;
    }

    public void setStore_tel(String store_tel)
    {
        this.store_tel = store_tel;
    }

    public Long getPay_config_user_id()
    {
        return pay_config_user_id;
    }

    public void setPay_config_user_id(Long pay_config_user_id)
    {
        this.pay_config_user_id = pay_config_user_id;
    }

    public Date getPay_config_time()
    {
        return pay_config_time;
    }

    public void setPay_config_time(Date pay_config_time)
    {
        this.pay_config_time = pay_config_time;
    }

    public Integer getIs_invoice()
    {
        return is_invoice;
    }

    public void setIs_invoice(Integer is_invoice)
    {
        this.is_invoice = is_invoice;
    }

    public String getInvoice_header()
    {
        return invoice_header;
    }

    public void setInvoice_header(String invoice_header)
    {
        this.invoice_header = invoice_header;
    }

    public Integer getIs_read()
    {
        return is_read;
    }

    public void setIs_read(Integer is_read)
    {
        this.is_read = is_read;
    }

    public Integer getInvoice_type()
    {
        return invoice_type;
    }

    public void setInvoice_type(Integer invoice_type)
    {
        this.invoice_type = invoice_type;
    }

    public Integer getAttribute()
    {
        return attribute;
    }

    public void setAttribute(Integer attribute)
    {
        this.attribute = attribute;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Integer getEvaluate_status()
    {
        return evaluate_status;
    }

    public void setEvaluate_status(Integer evaluate_status)
    {
        this.evaluate_status = evaluate_status;
    }

    public Long getParent_id()
    {
        return parent_id;
    }

    public void setParent_id(Long parent_id)
    {
        this.parent_id = parent_id;
    }

    public Integer getDrink_type()
    {
        return drink_type;
    }

    public void setDrink_type(Integer drink_type)
    {
        this.drink_type = drink_type;
    }

    public Integer getActivity_type()
    {
        return activity_type;
    }

    public void setActivity_type(Integer activity_type)
    {
        this.activity_type = activity_type;
    }

    public BigDecimal getPaid_money()
    {
        return paid_money;
    }

    public void setPaid_money(BigDecimal paid_money)
    {
        this.paid_money = paid_money;
    }

    public BigDecimal getNo_discount_money()
    {
        return no_discount_money;
    }

    public void setNo_discount_money(BigDecimal no_discount_money)
    {
        this.no_discount_money = no_discount_money;
    }

    public BigDecimal getPaid_discount_money()
    {
        return paid_discount_money;
    }

    public void setPaid_discount_money(BigDecimal paid_discount_money)
    {
        this.paid_discount_money = paid_discount_money;
    }

    public BigDecimal getOrder_discount()
    {
        return order_discount;
    }

    public void setOrder_discount(BigDecimal order_discount)
    {
        this.order_discount = order_discount;
    }

    public String getActivity_name()
    {
        return activity_name;
    }

    public void setActivity_name(String activity_name)
    {
        this.activity_name = activity_name;
    }

    public String getEat_number()
    {
        return eat_number;
    }

    public void setEat_number(String eat_number)
    {
        this.eat_number = eat_number;
    }

    public List<OrderItem> getItemList()
    {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList)
    {
        this.itemList = itemList;
    }

}
