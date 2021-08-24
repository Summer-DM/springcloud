package com.summer.springcloud.springcloudcommon.commonResult;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.net.ConnectException;

/**
 * @Author Summer_DM
 * @Summary TODO  公共返回结果封装
 * @Version 1.0
 * @Date 2021/8/13 下午 02:27
 **/
public class Result<T> implements Serializable{
    private static final long serialVersionUID = 1L;
    private static final Logger log= LoggerFactory.getLogger(Result.class);
    /**
     * 返回状态
     */
    private Boolean status=true;
    /**
     * 状态码
     */
    private String code;
    /**
     * 业务码
     */
    private String type;
    /**
     * 状态说明
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    /**
     * 返回成功
     * @param type 业务码
     * @param message 错误说明
     * @param data 数据
     */
    public Result(String type, String message, T data) {
        this.status=true;
        this.code ="0000";
        this.type=type;
        this.message = message;
        this.data=data;
    }
    public Result() {
        this.status=true;
        this.code ="0000";
    }
    public Result(Throwable throwable) {
        log.error(throwable+"tt");
        this.status=false;
        if(throwable instanceof FeignException){
            this.code= "0001";
            this.message="参数失败"+throwable;
        }else if(throwable instanceof RuntimeException){
            this.code= "1002";
            this.message="链接失败"+throwable;
        }else if(throwable instanceof HystrixTimeoutException){
            this.code= "1003";
            this.message="链接超时"+throwable;
        }else if(throwable instanceof ConnectException){
            this.code= "1002";
            this.message="链接失败"+throwable;
        }else if(throwable instanceof Exception){
            log.error("未知异常"+throwable);
            this.code= "9999";
            this.message="未知异常"+throwable;
        }
    }
}
