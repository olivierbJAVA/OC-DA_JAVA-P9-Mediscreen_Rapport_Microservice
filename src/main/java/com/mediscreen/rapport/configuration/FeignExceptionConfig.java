package com.mediscreen.rapport.configuration;

import com.mediscreen.rapport.exception.CustomErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Feign exceptions management.
 */
@Configuration
public class FeignExceptionConfig {

    @Bean
    public CustomErrorDecoder mCustomErrorDecoder(){
        return new CustomErrorDecoder();
    }

}
