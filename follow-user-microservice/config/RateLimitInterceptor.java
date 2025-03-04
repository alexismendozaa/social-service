package com.socialservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Implements rate limiting to prevent excessive API requests from the same IP.
 */
public class RateLimitInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(RateLimitInterceptor.class);

    private static final int MAX_REQUESTS = 100;
    private static final long TIME_WINDOW = 15 * 60 * 1000; // 15 minutes
    private static final ConcurrentHashMap<String, RequestInfo> requestCounts = new ConcurrentHashMap<>();

    private static class RequestInfo {
        AtomicInteger count;
        long timestamp;

        RequestInfo() {
            this.count = new AtomicInteger(1);
            this.timestamp = System.currentTimeMillis();
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = request.getRemoteAddr();
        long currentTime = System.currentTimeMillis();

        requestCounts.compute(ip, (key, info) -> {
            if (info == null || (currentTime - info.timestamp) > TIME_WINDOW) {
                return new RequestInfo();
            }
            info.count.incrementAndGet();
            return info;
        });

        int requestCount = requestCounts.get(ip).count.get();
        if (requestCount > MAX_REQUESTS) {
            logger.warn("⛔ IP temporarily blocked due to excessive requests: " + ip);
            response.setStatus(429);
            response.getWriter().write("Too many requests. Try again later.");
            return false;
        }
        return true;
    }
}
