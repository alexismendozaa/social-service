
package com.socialservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

@Configuration
public class RateLimitConfig {
    @Bean
    public HandlerInterceptor rateLimitInterceptor() {
        return new RateLimitInterceptor();
    }
}