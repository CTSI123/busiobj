package cn.com.ctsi.busiobj.config;

import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.Retryer;
import feign.hystrix.HystrixFeign;
import org.springframework.context.annotation.Bean;

public class FeiginClientConfig {
    @Bean
    Logger.Level feignLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    Retryer feignRetryer() {
        return new Retryer.Default(10000, 10000, 1);
    }

    @Bean
    Request.Options feignRequestOptions() {
        return new Request.Options(30000, 30000);
    }

    Feign.Builder feignBuilder() {
        return new HystrixFeign.Builder()
                .logLevel(feignLevel())
                .retryer(feignRetryer())
                .options(feignRequestOptions());
    }
}
