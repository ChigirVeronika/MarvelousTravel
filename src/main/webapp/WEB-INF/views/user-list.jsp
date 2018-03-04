<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:setLocale value="ru"/>
<fmt:setBundle basename="i18n.marvelous_travel" var="lang"/>

<html lang="${language}">
<head>
    <jsp:include page="layout/resources.jsp"/>
</head>

<body onkeydown="return Disable()">
<div class="site-wrapper">
    <div class="site-wrapper-inner">
        <div class="cover-container">
            <div class="trendhead clearfix">
                <jsp:include page="layout/header.jsp"/>
            </div>
            <div>
                <table>
                    <tr>
                        <td>Id</td>
                        <td>Name</td>
                        <td>Surname</td>
                        <td>Birthday</td>
                        <td>Gender</td>
                        <td>Passport</td>
                        <td>Phone</td>
                        <td>Marital Status</td>
                        <td>Role</td>
                        <td>Email</td>
                        <td>Income</td>
                        <td>Is Parent</td>
                        <td>Group</td>
                        <td>Home city</td>
                    </tr>

                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.surname}</td>
                            <td>${user.birthday}</td>
                            <td>${user.gender}</td>
                            <td>${user.passport}</td>
                            <td>${user.phone}</td>
                            <td>${user.maritalStatus}</td>
                            <td>${user.role.name}</td>
                            <td>${user.email}</td>
                            <td>${user.income}</td>
                            <td>${user.isParent}</td>
                            <td>${user.group.getName()}</td>
                            <td>${user.home.getName()}</td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="row">
                    <div class="trendhead-brand">
                        <a href="<c:url value='/' />" class="btn btn-success custom-width">Переобучить нейронную
                            сеть</a>
                    </div>
                </div>

            </div>

        </div>
    </div>
</div>
</body>
</html>

