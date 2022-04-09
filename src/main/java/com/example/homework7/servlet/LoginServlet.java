package com.example.homework7.servlet;

import javax.servlet.http.Cookie;
import java.io.PrintWriter;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        request.getRequestDispatcher("link.html").include(request, response);

        String name=request.getParameter("name");
        String password=request.getParameter("password");

        if(password.equals("root")){
            out.print("You are in!");
            out.print("<br>Welcome, "+name);

            Cookie negresa=new Cookie("name",name);
            response.addCookie(negresa);
        }else{
            out.print("username or password error!");
            request.getRequestDispatcher("login.html").include(request, response);
        }

        out.close();
    }
}
