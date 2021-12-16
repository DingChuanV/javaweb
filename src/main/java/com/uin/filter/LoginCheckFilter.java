package com.uin.filter;

import com.uin.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;


/**
 *
 */
@WebFilter(urlPatterns = "/news/*")
public class LoginCheckFilter implements Filter {

    Logger logger = Logger.getLogger("LoginCheckFilter");
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("==========init==========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

            HttpSession session = httpRequest.getSession();
            User user = (User)session.getAttribute("user");

            if (user == null) {
                httpResponse.sendRedirect("/index.jsp");
            }else {
                logger.info("用户登录成功！"+user);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        logger.info("==========destroy==========");

    }
}
