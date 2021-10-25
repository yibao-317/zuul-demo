package com.yibao.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author liyi
 * @create 2021 -10 -25 -16:17
 */
@SpringBootApplication
@EnableZuulProxy  // 开启 zuul
@EnableEurekaClient  // 开启Eureka
public class SentinelApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication.class, args);
    }
}
