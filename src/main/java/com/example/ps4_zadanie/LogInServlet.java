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

        String loginValue = request.getParameter("login");
        String passwordValue = request.getParameter("password");
        String rememberMeValue = request.getParameter("rememberMe");

        session.setAttribute("isLogged", true);
        session.setAttribute("login", loginValue);
        session.setAttribute("password", passwordValue);
        session.setAttribute("rememberMe", rememberMeValue);

        String message = "";
        Cookie[] cookies = request.getCookies();

        if(request.getParameter("rememberMe") != null){ //if we mark checkbox
           message = "Login and Password saved in cookies";

           for(Cookie cookie : cookies) { //searching for duplicate cookies
               if(cookie.getName().equals(loginValue)){
                   String cookieDuplicate = cookie.getValue();
                   System.out.println("LogIn doGet(): Cookie is duplicate  : " + cookieDuplicate );
                   break;
               }
               else{ //if cookie is not duplicated we save it
                   Cookie userCookie = new Cookie(loginValue, passwordValue);
                   userCookie.setMaxAge(60 * 60 * 24); // 1 day
                   response.addCookie(userCookie);
                   System.out.println("LogIn doGet(): Cookie saved in browser. ");
               }
           }
           System.out.println("LogIn doGet(): cookieString: " + loginValue + " " + passwordValue);
        }
        else { //if we did not mark chceckbox
            if(cookies != null) { //if we have any cookie
                for(Cookie cookie : cookies) { //searching for duplicate cookies
                    if(cookie.getName().equals(loginValue)){
                        String cookieValue = cookie.getValue();
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                        System.out.println("LogIn doGet(): Empty checkbox, value was before we delete the cookie : " + cookieValue );
                        break;
                    }
                }
                System.out.println("LogIn doGet(): Not cookieFirst login, did not mark chceckbox" );
            }
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> LogIn </h1>");
        out.println("<h1> " + message + " </h1>");
        out.println("<a href=http://localhost:8080/PS4_zadanie_war_exploded/ > Return to main page </a>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
        System.out.println("LogIn destroy(): ");
    }
}
