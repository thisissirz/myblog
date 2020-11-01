package com.whgc.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if(request.getSession().getAttribute("user")==null){
            request.setAttribute("msg","没有权限先登录！");
            //response.sendRedirect("/login");  springboot start
            response.sendRedirect("/myblog/login");  //tomcat start
            return false;
        }
        return true;
    }
}
