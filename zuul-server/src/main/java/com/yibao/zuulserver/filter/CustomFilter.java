package com.yibao.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义过滤器
 *
 * @author liyi
 * @create 2021 -10 -24 -23:07
 */
@Component
public class CustomFilter extends ZuulFilter {
    // 日志
    private static final Logger logger = LoggerFactory.getLogger(ZuulFilter.class);

    /**
     * 过滤器类型：pre\routing\post\error
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 执行顺序 0 ~ ... 越小越靠前
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否开启此过滤器
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 方法：此过滤器具体的执行逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 获取请求上下文
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        // 获取token
        String token = request.getParameter("token");
        // 判断是否携带 token
        if (null == token) {
            logger.error("token is null...");
            // 请求结束
            context.setSendZuulResponse(false);
            // 响应状态码 -- 401 无访问权限
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            // 响应类型
            context.getResponse().setContentType("application/json;charset=utf-8");
            PrintWriter writer = null;
            try {
                writer = context.getResponse().getWriter();
                // 响应内容
                writer.print(HttpStatus.SC_UNAUTHORIZED);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (null != writer) {
                    writer.close();
                }
            }
        } else {
            // 使用 token 进行身份验证
            logger.info("token is ok !");

        }
        return null;
    }
}