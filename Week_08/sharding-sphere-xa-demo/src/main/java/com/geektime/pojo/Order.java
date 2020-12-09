package com.geektime.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author YangMin
 * @date 2020/12/8 13:54
 */
@Data
public class Order {
    private Long orderId;
    private Long userId;
    private Long userAddressId;
    private BigDecimal orderMoney;
    private int orderPaystate;
    private Date orderCreateTime;
    private Date orderModifyTime;
}
