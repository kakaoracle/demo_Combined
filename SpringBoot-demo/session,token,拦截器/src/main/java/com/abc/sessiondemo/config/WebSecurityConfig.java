package com.abc.sessiondemo.config;

/*
* 拦截器
* */

import com.abc.sessiondemo.Util.JWT;
import com.abc.sessiondemo.vo.TokenVo;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 登录配置
 */
@Log
@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {
    public final static String SESSION_KEY="username";
    public static String USER_ID="123";



    // 设置跨域访问
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/cors/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600000);

    }

    //重写
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
            //设置放行的swagger资源
            registry.addResourceHandler("swagger-ui.html")
                    .addResourceLocations("classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    public SecurityInterceptor getSecurityInterceptor(){
        return new SecurityInterceptor();
    }

    public void  addInterceptors(InterceptorRegistry registry){
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
        //排除项
        addInterceptor.excludePathPatterns("/**/login*");//排除登录页
        addInterceptor.excludePathPatterns("/file/**");//排除文件
        addInterceptor.excludePathPatterns("/**.html","/v2/api-docs","/swagger-resources/**","/webjars/**");//swaggerui页面

        //添加error时就无法在其他页面拦截，因为controller找不到时跳转到error且不会拦截，但是加了以后就需要保证登录参数正确
        addInterceptor.excludePathPatterns("/error");
        //其他全部拦截
        addInterceptor.addPathPatterns("/**");
    }


    private class SecurityInterceptor extends HandlerInterceptorAdapter {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
            //添加跨域
            response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.addHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,PUT,DELETE,HEAD");
            response.addHeader("Access-Control-Allow-Headers", "S_ID,content-type,token");//放行的请求头参数
            response.addHeader("Access-Control-Max-Age", "3600000000");
            response.addHeader("Access-Control-Allow-Credentials", "true");

            //HttpSession session = request.getSession();
            //log.info("-----session存活时间: "+request.getSession().getMaxInactiveInterval());
            //response.addCookie(new Cookie("JSSESIONID",request.getSession().getId()));
//          判断是否已有该用户登录的session
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                log.info("-----headerName: "+headerName+",vaule: "+request.getHeader(headerName));
            }
            String tokenStr =  request.getHeader("token");
            log.info("-----从请求头中获取的token: "+tokenStr);
            if (!StringUtils.isBlank(tokenStr)){
                TokenVo unsignResult = JWT.unsign(tokenStr, TokenVo.class);
                log.info("----解密出来的vo: "+unsignResult);
                //根据解密出来的id查询出来数据库,存在即算验证成功
                /*if (!StringUtils.isBlank(userVo.getPassword())){
                    WebSecurityConfig.USER_ID = userVo.getUserID();
                    log.info("-----userId被设置为: "+ WebSecurityConfig.USER_ID);
                    return true;
                }else {
                    sendJsonMessage(response, MsgResult.build(603,"sessionVerify fail"));
                    return false;
                }*/
            }
           /* if(session.getAttribute(SESSION_KEY) != null){
                log.info("-----session验证成功： "+session.getAttributeNames().nextElement());
                return true;
            }*/
            log.info("-----token验证失败，无法登录,请求："+request.getRequestURI()+",token: "+tokenStr
            +",ip: "+request.getRemoteAddr());
//          没有session就通知跳转到登录页面
            sendJsonMessage(response, "返回的信息");
            return false;
        }
    }
    public static void sendJsonMessage(HttpServletResponse response, Object obj){
        try {
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(JSONObject.toJSON(obj));
            writer.close();
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
