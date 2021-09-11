package com.summer.strategymode.service.impl;

import com.summer.strategymode.model.Order;
import com.summer.strategymode.model.PayResult;
import com.summer.strategymode.service.IPayment;
import org.springframework.stereotype.Service;

/**
 * @Author Summer_DM
 * @Summary TODO  云闪付支付，需要实现支付的接口
 * @Version 1.0
 * @Date 2021/9/9 上午 09:59
 **/
@Service("UnionPay")
public class UnionPay implements IPayment {
    /**
     * 支付
     *
     * @param order
     * @return
     */
    @Override
    public PayResult pay(Order order) {
        return new PayResult("云闪付支付成功");
    }
}
