package com.zcf;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("count", 0);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet()...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost()...");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        ServletContext servletContext = this.getServletContext();
        String host = servletContext.getInitParameter("host");
        System.out.println(host);


        if (username.equals("zcf") && password.equals("123456")) {
            Integer count = (Integer) getServletContext().getAttribute("count");
            count++;
            getServletContext().setAttribute("count", count);
            resp.getWriter().write("login success, No." + count);

        } else {
            resp.getWriter().write("login failed");
        }



    }
}
