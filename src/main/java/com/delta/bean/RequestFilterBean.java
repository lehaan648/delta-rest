package com.delta.bean;

import com.delta.filter.RequestFilter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Lakshit on 27-05-2018.
 */

@Configuration
@Configurable
public class RequestFilterBean {

    @Bean
    public FilterRegistrationBean requestFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new RequestFilter());
        return registrationBean;
    }
}
