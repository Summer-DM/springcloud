##SSO测试说明

获取token：http://localhost:8006/oauth/token   
登录页：http://localhost:8006/login    
首页：http://localhost:8006    
订单页面：http://localhost:8006/order/list  
注销：http://localhost:8006/logout    
用户管理：http://localhost:8008/memberSystem/member/list   
订单管理：http://localhost:8007/orderSystem/order/list   

##简要说明一下Oauth2的工作流程
OAuth定义了四种角色：

**resource owner**（资源所有者）   
**resource server**（资源服务器）  
**client**（客户端）：代表资源所有者并且经过所有者授权去访问受保护的资源的应用程序  
**authorization server**（授权服务器）：在成功验证资源所有者并获得授权后向客户端发出访问令牌

    (A)  客户端向资源所有者请求其授权     
    (B)  客户端收到资源所有者的授权许可，这个授权许可是一个代表资源所有者授权的凭据  
    (C)  客户端向授权服务器请求访问令牌，并出示授权许可    
    (D)  授权服务器对客户端身份进行认证，并校验授权许可，如果都是有效的，则发放访问令牌    
    (E)  客户端向资源服务器请求受保护的资源，并出示访问令牌  
    (F)  资源服务器校验访问令牌，如果令牌有效，则提供服务

具体的说明，查阅博客：
https://www.cnblogs.com/cjsblog/p/9174797.html  
https://www.cnblogs.com/cjsblog/p/9184173.html

###几点说明
    SSO：是一种思想，或者说是一种解决方案，是抽象的，我们要做的就是按照它的这种思想去实现它
    OAuth2：是用来允许用户授权第三方应用访问他在另一个服务器上的资源的一种协议，它不是用来做单点登录的，但我们可以利用它来实现单点登录。
    JWT：用来生成OAuth2服务端发放给客户端的令牌，也就是说JWT是用来承载用户的Access_Token的
    Spring Security：是用于安全访问的，这里我们我们用来做访问权限控制    

**因为授权码的code大约10分钟会过期，所以每次需要再进行获取，获取方法：**_https://blog.csdn.net/qq_33542154/article/details/89851150_