<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html
        xmlns="http://www.w3.org/1999/xhtml"
        xmlns:f="http://java.sun.com/jsf/core"
        xmlns:h="http://java.sun.com/jsf/html"
        xmlns:ui="http://java.sun.com/jsf/facelets"
        xmlns:c="http://java.sun.com/jstl/core"
>
<head>
    <title>Zadanie 4</title>
</head>

<%--(2p) Należy napisać aplikację, która umożliwia logowanie użytkownika (za pomocą sesji). --%>
<%--Dodać możliwość “rememberMe” - zapamiętania danych logowania i wykonania go w automatyczny --%>
<%--sposób (z wykorzystaniem ciasteczek).--%>

<body>

<%  Boolean isLogged = (Boolean) session.getAttribute("isLogged");%>
<% String login = (String) session.getAttribute("login");%>

<%
    System.out.println("body: " + isLogged + " " + login);
    if(isLogged != null && isLogged) {
%>
<h1> Witaj użytkowniku <%= login %></h1>
<form action="LogOutServlet" method="get">
    <input type="submit" name="Logout">
</form>
<%
} else {
%>
<h1>Logowanie:</h1>
<form action="LogInServlet" method="get">
    <input type="text" name="login">
    <input type="password" name="password">
    <input type="submit" name="Login">
    <label for="rememberMe">Remember me</label>
    <input type="checkbox" id="rememberMe" name="rememberMe">
</form>
<%
    }
%>

    <%--<a href="hello-servlet">Hello Servlet</a>--%>
</body>
</html>