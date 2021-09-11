package com.summer.threadpooltaskexecutor.model;

import lombok.Data;

/**
 * @Author Summer_DM
 * @Summary TODO  测试类model
 * @Version 1.0
 * @Date 2021/9/6 上午 09:45
 **/
@Data
public class Common {

    private ScUser scUser;
    private Customer customer;


    public static void main(String[] args) {
        Common com = new Common();
        Customer cu = new Customer();
        com.setCustomer(cu);
        Customer customer = com.getCustomer();
        if (null != customer.getName()){
            System.out.println("5555");
        }
        System.out.println(customer);
    }
}
