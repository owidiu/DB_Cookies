package com.example.homework7.servlet;

import javax.servlet.http.Cookie;
import java.io.PrintWriter;

public class ProfileServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);

        Cookie negresa[]=request.getCookies();
        if(negresa!=null){
            String name=negresa[0].getValue();
            if(!name.equals("")||name!=null){
                out.print("<b>Your Profile</b>");
                out.print("<br>Welcome, "+name);
            }
        }else{
            out.print("Login first");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
    }
}
