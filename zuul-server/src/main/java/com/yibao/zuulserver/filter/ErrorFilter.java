package com.yibao.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author liyi
 * @create 2021 -10 -25 -11:56
 */
@Component
// Error 自定义过滤器
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 2;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        Throwable throwable = context.getThrowable();
        // 设置状态码 500
        context.setResponseStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        // 响应类型
        context.getResponse().setContentType("application/json;charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = context.getResponse().getWriter();
            // 响应内容
            writer.print("ErrorFilter -- message: " + HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                writer.close();
            }
        }
        return null;
    }
}
