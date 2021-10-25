package com.yibao.zuulserver.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * 对商品进行服务熔断处理
 *
 * @author liyi
 * @create 2021 -10 -25 -14:27
 */
@Component
public class ProductFallback implements FallbackProvider {
    /*
        方法: 返回服务名 -- 表示具体处理哪一个服务（只针对 "超时"）
     */
    @Override
    public String getRoute() {
        return "product-service";
    }

    /*
        方法：具体熔断操作
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            /*
                方法：状态码
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            /*
                方法：设置响应体
                    Zuul会将本方法返回的输入流数据读取，并通过HttpServletResponse的输出流输出到客户端
             */
            @Override
            public InputStream getBody() throws IOException {
                ByteArrayInputStream inputStream = new ByteArrayInputStream(
                        "message: 商品服务不可用，请稍后再试！".getBytes());
                return inputStream;
            }

            /*
                方法：设置响应的头信息
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(new MediaType("application",
                        "json",
                        Charset.forName("utf-8")));
                return headers;
            }
        };
    }
}
