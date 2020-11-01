package com.whgc.handler;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.whgc.exception.NotFoundException;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice   //拦截请求
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //指定将所有的异常都拦截掉
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHander(HttpServletRequest req,Exception e) throws Exception {
        //记录错误信息
        logger.error("request URL : {},Exception: {}",req.getRequestURL(),e);
        //当异常有一些状态码的时候，就不要拦截，然后就会根据这些状态码去找到对应的页面去了
        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){

            throw e;
        }


        ModelAndView mv = new ModelAndView();
        mv.addObject("url",req.getRequestURL());
        mv.addObject("exception",e);
        mv.setViewName("error/error");
        return mv;
    }
}
