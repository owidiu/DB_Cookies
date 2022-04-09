package com.example.homework7.servlet;

import javax.servlet.http.Cookie;
import java.io.PrintWriter;

public class LogoutServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.getSession().invalidate();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("link.html").include(request, response);

        Cookie negresa=new Cookie("negresa","");
        negresa.setMaxAge(0);
        response.addCookie(negresa);
        out.println("<h1>You have been logged out</h1>");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doPost(request, response);
    }
}
