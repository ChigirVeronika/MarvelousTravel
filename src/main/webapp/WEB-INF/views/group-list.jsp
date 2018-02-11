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

                <c:forEach items="${groups}" var="group">
                    <div class="row">
                        <h4 class="trendhead-brand">${group.name}</h4>
                        <h5 class="trendhead-brand">${group.age}</h5>
                        <h5 class="trendhead-brand">${group.gender}</h5>
                        <h5 class="trendhead-brand">${group.maritalStatus}</h5>
                        <h5 class="trendhead-brand">${group.income}</h5>
                        <h5 class="trendhead-brand">${group.isParent}</h5>
                        <h5 class="trendhead-brand">${group.info}</h5>
                        <h5 class="trendhead-brand">
                            <a href="<c:url value='/group/delete/${group.name}' />" class="btn btn-success custom-width">Удалить</a>
                        </h5>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>
