<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>BankingSystem</title>
    <link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"/>
</head>
<body>
<div>
    <div class="generic-container">
        <div>
                Hello!
        </div>


        <nav>
            <ul>
                <li><a href="<c:url value='/newslist' />">Show News</a></li>
                <li><a href="<c:url value='/logout' />">Logout</a></li>
            </ul>
        </nav>

    </div>

</div>
</body>

</html>