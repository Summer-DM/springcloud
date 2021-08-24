package com.summer.springcloud.springcloudcommon.commonResult;

/**
 * @Author Summer_DM
 * @Summary TODO
 * @Version 1.0
 * @Date 2021/8/16 下午 05:12
 **/
public enum ErrorEnum implements BaseErrorInfoInterface{
    /*sql错误*/
    InsertErr(1000,"插入数据出错"),
    SearchOneErr(1001,"查询一条数据，结果查找到多条"),
    UpdateErr(1002,"修改一条,结果修改了多条"),
    /*用户请求错误*/
    UserNameNull(2000,"用户名不能为空"),
    PasswordNull(2001,"密码不能为空"),
    ExistUser(2002,"用户已存在"),
    LoginTimeOut(2003,"登录超时"),
    LoginSuccess(2004,"登陆成功"),
    ErrUserNameORPassword(2005,"用户名或密码错误"),
    ArgumentsErr(2006,"参数有误"),
    RedundantOperation(2007,"无效的操作"),/*例如，试图添加两个相同的对象，而该操作不被系统允许*/
    UnknownErr(3002,"系统繁忙"),
    /*系统错误*/
    NullPointer(3001,"空指针异常"),
    OperationErr(3003,"操作异常"),

    /*数据库响应*/
    SuccessfulResponse(0000,"操作成功"),
    FailedResponse(44444,"操作失败");
    // 以上是枚举的成员，必须先定义，而且使用分号结束
    private final String description;
    private final int code;
    ErrorEnum(int code,String description) {
        this.description = description;
        this.code=code;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
