package com.uin.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 */
@WebFilter(filterName = "characterFilter",urlPatterns = "/*")
public class CharacterFilter implements Filter {

    Logger logger = Logger.getLogger("CharacterFilter");
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        logger.info("==========init==========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("==========destroy==========");
    }
}
