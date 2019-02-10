package com.ifen.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(AccessInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        setContentType(response);
        return super.preHandle(request, response, handler);
    }

    /**
     * 设置utf-8,解决中文问题
     * @param response
     */
    private void setContentType(HttpServletResponse response) {
        response.setContentType("application/json;charset=utf-8");
    }

    private void writeResult(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write("error!");
    }
}
