package com.suixingpay.client;

import org.springframework.context.annotation.Bean;

public class FallbackConfiguration {
    @Bean
    public FallbackClient fallbackFactory() {
        return new FallbackClient();
    }
}
