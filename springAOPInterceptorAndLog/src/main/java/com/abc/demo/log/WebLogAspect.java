package com.abc.demo.log;

import java.util.Arrays;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 实现Web层的日志切面
 */
@Aspect
@Component
@Order(-5)//优先级,在切入点前的操作，按order的值由小到大执行,在切入点后的操作，按order的值由大到小执行,为负数则第一个执行
public class WebLogAspect {
    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    /**
     * 定义一个切入点.
     * 第一个*符号表示返回值的类型任意；
       com.abc.demo	AOP所切的服务的包名，即，我们的业务部分
       包名后面的..	表示当前包及子包
      第二个*	表示类名，*即所有类。此处可以自定义，
       .*(..)	表示任何方法名，括号表示参数，两个点表示任何参数类型
     */
    @Pointcut("execution(public * com.abc.demo..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){

        // 接收到请求，记录请求内容
        logger.info("WebLogAspect.doBefore()");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return;
        }
        HttpServletRequest request = attributes.getRequest();


        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        //获取所有参数方法一：
        Enumeration<String> enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            System.out.println(paraName+": "+request.getParameter(paraName));
        }
    }

    @AfterReturning("webLog()")
    public void  doAfterReturning(JoinPoint joinPoint){
        // 处理完请求，返回内容
        logger.info("WebLogAspect.doAfterReturning()");
    }

}