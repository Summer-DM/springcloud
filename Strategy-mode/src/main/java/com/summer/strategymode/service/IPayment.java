package com.summer.strategymode.service;


import com.summer.strategymode.model.Order;
import com.summer.strategymode.model.PayResult;

/**
 * @Author Summer_DM
 * @Summary TODO  定义一个支付的公共父级接口
 * @Version 1.0
 * @Date 2021/9/9 上午 09:52
 **/
public interface IPayment {
    /**
     * 支付
     * @param order
     * @return
     */
    PayResult pay(Order order);
}
