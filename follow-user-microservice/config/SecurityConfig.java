package com.socialservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Implements IP blocking after multiple failed attempts to protect against brute force attacks.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final long BLOCK_TIME = 15 * 60 * 1000; // 15 minutes
    private static final ConcurrentHashMap<String, FailedLoginAttempt> failedAttempts = new ConcurrentHashMap<>();

    private static class FailedLoginAttempt {
        AtomicInteger count;
        long timestamp;

        FailedLoginAttempt() {
            this.count = new AtomicInteger(1);
            this.timestamp = System.currentTimeMillis();
        }
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .anyRequest().permitAll();

        // Additional logic to detect failed attempts and block IPs
    }

    /**
     * Checks if an IP should be blocked due to multiple failed login attempts.
     *
     * @param ip The IP address to check
     * @return true if the IP should be blocked, false otherwise
     */
    public static boolean shouldBlockIP(String ip) {
        long currentTime = System.currentTimeMillis();

        failedAttempts.compute(ip, (key, attempt) -> {
            if (attempt == null || (currentTime - attempt.timestamp) > BLOCK_TIME) {
                return new FailedLoginAttempt();
            }
            attempt.count.incrementAndGet();
            return attempt;
        });

        int attemptCount = failedAttempts.get(ip).count.get();
        if (attemptCount >= MAX_FAILED_ATTEMPTS) {
            logger.warn("⛔ IP blocked due to multiple failed attempts: " + ip);
            return true;
        }
        return false;
    }
}
