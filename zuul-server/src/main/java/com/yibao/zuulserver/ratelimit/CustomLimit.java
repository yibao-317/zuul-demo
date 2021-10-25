package com.yibao.zuulserver.ratelimit;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.RateLimitUtils;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.support.DefaultRateLimitKeyGenerator;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 方法：自定义限流策略
 *
 * @author liyi
 * @create 2021 -10 -25 -15:31
 */
@Component
public class CustomLimit extends DefaultRateLimitKeyGenerator {

    public CustomLimit(RateLimitProperties properties, RateLimitUtils rateLimitUtils) {
        super(properties, rateLimitUtils);
    }

    /**
     * 方法：限流逻辑
     *
     * @param request
     * @param route
     * @param policy
     * @return
     */
    @Override
    public String key(HttpServletRequest request, Route route, RateLimitProperties.Policy policy) {
        // 对请求参数中相同的 id 进行限流
        return super.key(request, route, policy) + ":" + request.getParameter("id");
    }
}
