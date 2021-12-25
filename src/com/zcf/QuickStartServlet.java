package com.zcf;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class QuickStartServlet implements Servlet {

    ServletContext servletContext = null;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init()...");
        String servletName = servletConfig.getServletName();
        System.out.println("servlet name: " + servletName);

        servletContext = servletConfig.getServletContext();

        String url = servletConfig.getInitParameter("url");
        System.out.println("url: " + url);

        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        System.out.println("param names: ");
        while (initParameterNames.hasMoreElements()) {
            String element = initParameterNames.nextElement();
            System.out.println(element);

        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println(servletContext.getRealPath("a"));;
        System.out.println(servletContext.getRealPath("./WEB-INF/b"));
        System.out.println(servletContext.getRealPath("./WEB-INF/classes/c"));
        // d获取不到

        // 类加载器方式获取c文件
        String path = QuickStartServlet.class.getClassLoader().getResource("c").getPath();
        System.out.println(path);

        servletContext.setAttribute("msg","delete the specify file.");

        System.out.println("service() is running...");
        servletResponse.getWriter().write("Hello World!");



    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destory()...");

    }
}
