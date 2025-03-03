package com.socialservice.recipesearch.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class RateLimitInterceptor implements HandlerInterceptor {

    private final ConcurrentHashMap<String, Long> requestMap = new ConcurrentHashMap<>();
    private static final long LIMIT_TIME = TimeUnit.SECONDS.toMillis(5);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String clientIp = request.getRemoteAddr();
        long currentTime = System.currentTimeMillis();

        if (requestMap.containsKey(clientIp) && (currentTime - requestMap.get(clientIp)) < LIMIT_TIME) {
            response.setStatus(HttpServletResponse.SC_TOO_MANY_REQUESTS);
            response.getWriter().write("Rate limit exceeded. Try again later.");
            return false;
        }

        requestMap.put(clientIp, currentTime);
        return true;
    }
}
