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
                <div class="row">
                    <h3 class="trendhead-brand">
                        <a href="<c:url value='/group/create' />" class="btn btn-success custom-width">Создать</a>
                    </h3>
                </div>
                <div class="row">
                    <table>
                        <tr>
                            <td>Name</td>
                            <td>Age</td>
                            <td>Gender</td>
                            <td>Marital status</td>
                            <td>Income</td>
                            <td>Is parent</td>
                            <td>Info</td>
                            <td>Delete</td>
                        </tr>
                        <c:forEach items="${groups}" var="group">
                            <tr>
                                <td><h4 class="trendhead-brand">${group.name}</h4></td>
                                <td><h5 class="trendhead-brand">${group.age}</h5></td>
                                <td><h5 class="trendhead-brand">${group.gender}</h5></td>
                                <td><h5 class="trendhead-brand">${group.maritalStatus}</h5></td>
                                <td><h5 class="trendhead-brand">${group.income}</h5></td>
                                <td><h5 class="trendhead-brand">${group.isParent}</h5></td>
                                <td><h5 class="trendhead-brand">${group.info}</h5></td>
                                <td>
                                    <h5 class="trendhead-brand">
                                        <a href="<c:url value='/group/delete/${group.name}' />"
                                           class="btn btn-success custom-width">Delete
                                        </a>
                                    </h5>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
