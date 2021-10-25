package com.yibao.sentinel.config;

import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulErrorFilter;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulPostFilter;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.filters.SentinelZuulPreFilter;
import com.netflix.zuul.ZuulFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;

/**
 * 网关服务类配置
 *
 * @author liyi
 * @create 2021 -10 -25 -16:51
 */
@Component
public class ZuulConfig {

    @Bean
    public ZuulFilter sentinelZuulPreFilter() {
        return new SentinelZuulPreFilter();
    }

    @Bean
    public ZuulFilter sentinelZuulPostFilter() {
        return new SentinelZuulPostFilter();
    }

    @Bean
    public ZuulFilter sentinelZuulErrorFilter(){
        return new SentinelZuulErrorFilter();
    }

    /**
     *  Spring 容器初始化的时候执行该方法
     */
    @PostConstruct
    public void doInit(){
        // 加载网关限流规则
        initGatewayRules();
    }

    /**
     * 方法：限流规则
     */
    private void initGatewayRules() {
        HashSet<GatewayFlowRule> rules = new HashSet<>();
        // 规则
        rules.add(new GatewayFlowRule("order-service")  // 服务名称
                .setCount(3)   // 限流阀值
                .setIntervalSec(60));   // 统计时间窗口，单位 秒 S
        // 加载规则
        GatewayRuleManager.loadRules(rules);
    }

}
