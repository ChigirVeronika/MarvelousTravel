<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List</title>
    <link href="<c:url value='/resources/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">News</span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Created date</th>
                <th width="100"></th>
                <th width="100"></th>
                <th width="160"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${news}" var="lnews">
                <tr>
                    <td>${lnews.name}</td>
                    <td>${lnews.content}</td>
                    <td>${lnews.date}</td>
                    <td><a href="<c:url value='/news-edit-${lnews.name}' />" class="btn btn-success custom-width">edit</a></td>
                    <td><a href="<c:url value='/news-delete-${lnews.name}' />" class="btn btn-danger custom-width">delete</a></td>
                    <td>
                        <a href="<c:url value='/reviews-create-${lnews.name}' />" class="btn btn-warning custom-width">create review</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
