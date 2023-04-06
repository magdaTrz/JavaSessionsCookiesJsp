<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Zadanie 4</title>
</head>

<%--(2p) Należy napisać aplikację, która umożliwia logowanie użytkownika (za pomocą sesji). --%>
<%--Dodać możliwość “rememberMe” - zapamiętania danych logowania i wykonania go w automatyczny --%>
<%--sposób (z wykorzystaniem ciasteczek).--%>

<body>
    <h1>Logowanie:</h1>

    <form action="LogInServlet" method="post">
        <input type="text" name="login">
        <input type="password" name="password">
        <input type="submit" name="Login">
    </form>

    <%--<a href="hello-servlet">Hello Servlet</a>--%>
</body>
</html>