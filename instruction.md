#模块说明
    本项目为一个简单的微服务(Springcloud)架构，主要是为了帮助笔者理解一些简单的逻辑！目前前端使用的是springboot默认的thymeleaf框架，后续可能会修改成JSP！！！
####现在是本地，windows版本的。

###项目环境
JDK：1.8     
maven：3.5   
springboot：2.5.3   
mysql:8.0   
注册中心：Eureka  
ORM：Mybatis-Plus  3.4.3.1


###项目模块
注册服务中心：spring-cloud-server  
公共工具模块：spring-cloud-common  
用户请求接口：spring-cloud-user    
公共实体模块：spring-cloud-entity  
公共工具类(mybatis-plus自动生成)：spring-cloud-utils  
对外提供api入口层：spring-cloud-web     
SSO单点登录服务器：oauth2-sso-auth-server   
订单服务(针对SSO)：oauth2-sso-auth-order   
用户服务（针对SSO）：oauth2-sso-auth-member    
待定：spring-cloud-cloud  


###目前实现功能
1、拦截器实现（主要是针对登录所做）---spring-cloud-user  
2、登录接口---spring-cloud-user  
3、用户查询（分页查询）---spring-cloud-user  
4、新增用户（目前不支持批量）---spring-cloud-user  
5、定义全局异常、报错返回页面（包括浏览器访问和postman工具测试） ---spring-cloud-user    
6、文件上传下载（支持单文件、多文件上传），目前仅支持项目根路径或者同服务器的文件操作---spring-cloud-common  
7、工具类（日期转换、request入参解析、文件操作等），其他工具类的使用本项目引入了HuTool，可以参考HuTool官网(https://www.hutool.cn/docs/#/ )使用 ---spring-cloud-common    
8、统一返回结果（自定义统一的返回结果result）---spring-cloud-common  
9、SSO单点登录（使用OAuth2来实现的SSO）




###特别说明
    SSO服务是在git上抄用别人的代码，自己去理解（原博客地址：https://www.cnblogs.com/cjsblog/p/10548022.html）

