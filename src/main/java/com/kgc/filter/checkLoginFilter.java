package com.kgc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class checkLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("你想进去吗??");
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;

        String requestURI = request.getRequestURI();
        String path=requestURI.substring(requestURI.lastIndexOf("/")+1);
        System.out.println(path);

        if (path.equals("login.jsp")||path.equals("login")||path.equals("regs.jsp")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            HttpSession session = request.getSession();
            Object o = session.getAttribute("loginInfo");
            if (o==null){
                response.sendRedirect("login.jsp");
            }else {
                filterChain.doFilter(servletRequest,servletResponse);
            }

        }


    }

    @Override
    public void destroy() {

    }
}
