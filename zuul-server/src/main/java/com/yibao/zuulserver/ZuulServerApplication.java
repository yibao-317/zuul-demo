package com.yibao.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @author liyi
 * @create 2021 -10 -24 -22:11
 */
@SpringBootApplication
@EnableZuulProxy  // 开启 zuul
@EnableEurekaClient  // 开启 Eureka
@EnableHystrixDashboard  // 开启数据监控
@EnableRetry  // 开启 zuul重试机制
public class ZuulServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }
}
