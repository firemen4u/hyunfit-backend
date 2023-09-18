package com.backend.hyunfit.global.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Value("${cross-origin.backend-ec2-ip}")
    private String backendEc2Ip;

    @Value("${cross-origin.frontend-url}")
    private String frontendUrl;

    @Value("${cross-origin.vue-localhost}")
    private String vueLocalhost;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.addAllowedOrigin(backendEc2Ip);
        config.addAllowedOrigin(frontendUrl);
        config.addAllowedOrigin(vueLocalhost);
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.addExposedHeader("Authorization");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
