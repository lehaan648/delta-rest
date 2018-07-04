package com.delta.filter;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lakshit on 26-05-2018.
 */

public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        List<String> excludeUrls = new ArrayList<>();
        excludeUrls.add("/login");
        String header = request.getHeader("Authorization");
        if (!excludeUrls.contains(request.getRequestURI().toString())) {
            if (!this.checkAuthorizationHeader(header)) {
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }

    public boolean checkAuthorizationHeader(String headerValue) {
        if (headerValue == null) {
            return false;
        }
        String [] headers = headerValue.split(" ");
        if (headers.length != 2) {
            return false;
        }

        if (headers[0].equals("Bearer") && headers[1].equals("fake token")) {
            return true;
        }
        return false;
    }
}
