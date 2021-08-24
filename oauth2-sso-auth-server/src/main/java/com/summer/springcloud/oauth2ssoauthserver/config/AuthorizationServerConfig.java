package com.summer.springcloud.oauth2ssoauthserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;

/**
 * @Author Summer_DM
 * @Summary TODO  Oauth2---AuthorizationServer配置类  3个configure调用顺序:AuthorizationServerEndpointsConfigurer、ClientDetailsServiceConfigurer、AuthorizationServerSecurityConfigurer、
 * @Version 1.0
 * @Date 2021/8/19 下午 04:48
 **/
@Configuration
@EnableAuthorizationServer//用来配置授权服务器
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    /**
     * 定义令牌端点上的安全约束
     *  配置：安全检查流程,用来配置令牌端点（Token Endpoint）的安全与权限访问
     *  默认过滤器：BasicAuthenticationFilter
     *  1、oauth_client_details表中clientSecret字段加密【ClientDetails属性secret】
     *  2、CheckEndpoint类的接口 oauth/check_token 无需经过过滤器过滤，默认值：denyAll()
     * 对以下的几个端点进行权限配置：
     * /oauth/authorize：授权端点
     * /oauth/token：令牌端点
     * /oauth/confirm_access：用户确认授权提交端点
     * /oauth/error：授权服务错误信息端点
     * /oauth/check_token：用于资源服务访问的令牌解析端点
     * /oauth/token_key：提供公有密匙的端点，如果使用JWT令牌的话
     **/
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients()//允许客户表单认证
                .passwordEncoder(new BCryptPasswordEncoder())//设置oauth_client_details中的密码编码器
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    /**
     *定义客户端详细信息服务的配置器
     * 配置从哪里获取ClientDetails信息。
     * 在client_credentials授权方式下，只要这个ClientDetails信息。
     * @param clientsDetails
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clientsDetails) throws Exception {
        clientsDetails.jdbc(dataSource);
    }

    /**
     * 定义授权和令牌端点以及令牌服务
     * 注入相关配置：
     * 1. 密码模式下配置认证管理器 AuthenticationManager
     * 2. 设置 AccessToken的存储介质tokenStore， 默认使用内存当做存储介质。
     * 3. userDetailsService注入
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //这里说明Token存储采用的是JWT
        endpoints.accessTokenConverter(jwtAccessTokenConverter());
        endpoints.tokenStore(jwtTokenStore());
//        endpoints.tokenServices(defaultTokenServices());
    }

    /*@Primary
    @Bean
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(jwtTokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }*/

    @Bean
    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("cjs");   //  Sets the JWT signing key
        return jwtAccessTokenConverter;
    }

}
