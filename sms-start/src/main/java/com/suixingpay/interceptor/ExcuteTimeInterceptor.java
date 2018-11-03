package com.suixingpay.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: Dana_ZHANG;email:1602334641@qq.com
 * @Date: 2018/11/2 14:45
 * @Description:
 */
@Slf4j
public class ExcuteTimeInterceptor implements HandlerInterceptor {
    /**
     * @method preHandle()：记录请求执行前的时间，并放入request中
     * startTime:记录响应时的实时时间
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        long startTime=System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }

    /**
     * @method postHandle()：记录请求执行后的时间，并计算时间差，打印日志
     * endTime:记录响应时的实时时间
     * excuteTime：操作时间差
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)throws Exception{
        long startTime=(Long)request.getAttribute("startTime");
        long endTime=System.currentTimeMillis();
        long excuteTime=endTime-startTime;

        System.out.println(""+excuteTime+" ms");
        log.info("【日志打印】--操作所用时间："+excuteTime+" ms");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}