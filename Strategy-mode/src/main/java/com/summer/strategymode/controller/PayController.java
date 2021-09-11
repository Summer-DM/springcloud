package com.summer.strategymode.controller;

import com.summer.strategymode.model.Order;
import com.summer.strategymode.model.PayResult;
import com.summer.strategymode.service.IPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Summer_DM
 * @Summary TODO  外部调用接口
 * @Version 1.0
 * @Date 2021/9/9 上午 10:01
 **/
@RestController
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 支付接口
     * @param amount
     * @param paymentType
     * @return
     */
    @RequestMapping("/toPay")
    public PayResult pay(@RequestParam("amount") int amount,
                         @RequestParam("paymentType") String paymentType) {
        Order order = new Order();
        order.setAmount(amount);
        order.setPaymentType(paymentType);
        // 根据支付类型获取对应的策略 bean
        IPayment payment = applicationContext.getBean(order.getPaymentType(), IPayment.class);
        // 开始支付
        PayResult payResult = payment.pay(order);
        return payResult;
    }

}
