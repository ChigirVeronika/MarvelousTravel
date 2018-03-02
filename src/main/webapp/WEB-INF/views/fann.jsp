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
                        <a href="<c:url value='/fann-statistics' />" class="btn btn-success custom-width">Statistics page</a>
                    </h3>
                </div>
                <div class="row">
                    <h3 class="trendhead-brand">
                        <a href="<c:url value='/fann/trainwork/easy' />" class="btn btn-success custom-width">Easy train & run fann</a>
                    </h3>
                    <h3 class="trendhead-brand">
                        ${fannEasyTrainMessage}
                    </h3>
                    <h3 class="trendhead-brand">
                        ${fannEasyWorkMessage}
                    </h3>
                    <c:if test="${changedUsersEasy}">
                        <c:forEach items="${changedUsersEasy}" var="element">
                            <div>${element.key.name} ${element.key.surname} Почта: ${element.key.email} Группа: ${element.value.getName()}</div>
                        </c:forEach>
                    </c:if>
                    <h3 class="trendhead-brand">
                        <a href="<c:url value='/fann/trainwork/heavy' />" class="btn btn-success custom-width">Heavy train & run fann</a>
                    </h3>
                    </h3>
                    <h3 class="trendhead-brand">
                        ${fannHeavyTrainMessage}
                    </h3>
                    <h3 class="trendhead-brand">
                        ${fannHeavyWorkMessage}
                    </h3>
                    <c:if test="${changedUsersHeavy}">
                        <c:forEach items="${changedUsersHeavy}" var="element">
                            <div>${element.key.name} ${element.key.surname} Почта: ${element.key.email} Группа: ${element.value.getName()}</div>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
