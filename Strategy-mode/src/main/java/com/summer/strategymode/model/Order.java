package com.summer.strategymode.model;

import lombok.Data;

/**
 * @Author Summer_DM
 * @Summary TODO  支付订单类
 * @Version 1.0
 * @Date 2021/9/9 上午 09:55
 **/
@Data
public class Order {
    /**
     * 金额
     */
    private int amount;

    /**
     * 支付类型
     */
    private String paymentType;

}
