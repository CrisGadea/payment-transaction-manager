package com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.interceptors;

import com.paymenttransaction.payment_transaction_manager.transactions.infrastructure.exceptions.IdempotencyKeyRequiredException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

@Component
public class IdempotencyInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(response instanceof ContentCachingResponseWrapper)) {
            response = new ContentCachingResponseWrapper(response);
        }

        String idempotencyKey = request.getHeader("Idempotency-Key");
        if (idempotencyKey == null) {
            throw new IdempotencyKeyRequiredException("Idempotency-Key header is required");
        }

        String cachedResponse = redisTemplate.opsForValue().get(idempotencyKey);
        if (cachedResponse != null) {
            response.setContentType("application/json");
            response.getWriter().write(cachedResponse);
            ((ContentCachingResponseWrapper) response).copyBodyToResponse(); // Aseguramos el envío
            return false;
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String idempotencyKey = request.getHeader("Idempotency-Key");
        if (idempotencyKey != null && response.getStatus() == HttpStatus.OK.value()) {
            if (response instanceof ContentCachingResponseWrapper) {
                ContentCachingResponseWrapper wrappedResponse = (ContentCachingResponseWrapper) response;

                try {
                    byte[] responseBytes = wrappedResponse.getContentAsByteArray();
                    String responseBody = new String(responseBytes, StandardCharsets.UTF_8);

                    // Saved on Redis with an expiration time of 24 hours.
                    redisTemplate.opsForValue().set(
                            idempotencyKey,
                            responseBody,
                            Duration.ofHours(24)
                    );

                    wrappedResponse.copyBodyToResponse();
                } catch (IOException e) {
                    throw new RuntimeException("Error procesando respuesta", e);
                }
            }
        }
    }
}