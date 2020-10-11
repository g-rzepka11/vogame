package com.vogame.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class Filters {

    private final GoogleTokenAuthenticationFilter loginFilter;
    private final RestFilter restFilter;

    @Autowired
    public Filters(GoogleTokenAuthenticationFilter loginFilter, RestFilter restFilter) {
        this.loginFilter = loginFilter;
        this.restFilter = restFilter;
    }

    @Bean
    public FilterRegistrationBean loginRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(loginFilter);
        filterRegistrationBean.setUrlPatterns(Collections.singletonList("/login/*"));
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean restRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(restFilter);
        filterRegistrationBean.setUrlPatterns(
                Arrays.asList("/wordpackages/*", "/games/*", "/users/*"));
        return filterRegistrationBean;
    }
}
