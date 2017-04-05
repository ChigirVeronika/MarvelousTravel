<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Вход</title>
    <link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="generic-container">
    <div class="well lead">Вход</div>
    <form method="post" action="login">
        <div>
            <label for="email">Email</label>
            <div>
                <input type="text" id="email" placeholder="Email" name="email">
            </div>
        </div>
        <div>
            <label for="password">Пароль</label>
            <div>
                <input type="password" id="password" placeholder="Password" name="password">
            </div>
        </div>
        <div>
            <div>
                <label class="checkbox">
                    <input type="checkbox"> Запомнить меня
                </label>
                <button type="submit">Войти</button>
                <p><font color="red">${error}</font></p>
            </div>
        </div>
    </form>
</div>
</div>
</body>
</html>