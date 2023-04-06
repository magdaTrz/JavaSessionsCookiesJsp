package com.example.ps4_zadanie;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogInServlet", value = "/LogInServlet")
public class LogInServlet extends HttpServlet {

    public void init() {
        System.out.println("LogIn init(): ");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("isLogged", true);
        session.setAttribute("login", request.getParameter("login"));
        session.setAttribute("password", request.getParameter("password"));
        session.setAttribute("rememberMe", request.getParameter("rememberMe"));

        System.out.println("LogIn doGet(): rememberMe:" + request.getParameter("rememberMe"));
        System.out.println("LogIn doGet(): Session:" + session);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> LogIn </h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
        System.out.println("LogIn destroy(): ");
    }
}
