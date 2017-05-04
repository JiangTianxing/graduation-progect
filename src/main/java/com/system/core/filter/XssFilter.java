package com.system.core.filter;

import com.system.core.util.XssHttpServletRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by jx on 2017/4/23.
 */
@WebFilter(urlPatterns = "/*", asyncSupported = true)
public class XssFilter implements Filter {
        private FilterConfig filterConfig = null;

        public void init(FilterConfig filterConfig) throws ServletException {
            this.filterConfig = filterConfig;
        }

        public void destroy() {
            this.filterConfig = null;
        }

        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            chain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) request), response);
        }
    }