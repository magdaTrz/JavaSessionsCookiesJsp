package com.example.ps4_zadanie;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogOutServlet", value = "/LogOutServlet")
public class LogOutServlet extends HttpServlet {

    public void init() {
        System.out.println("LogOut init(): ");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();

        System.out.println("LogOut doGet(): ");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> LogOut </h1>");
        out.println("<a href=http://localhost:8080/PS4_zadanie_war_exploded/ > Return to main page </a>");
        out.println("</body></html>");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
        System.out.println("LogOut destroy(): ");
    }
}
