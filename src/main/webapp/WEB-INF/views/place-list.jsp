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
            <div class="col-sm-8">
                <div class="row">
                    <h3 class="trendhead-brand">
                        <a href="<c:url value='/place/panel' />" class="btn btn-success custom-width">Search for places</a>
                    </h3>
                </div>

                <c:forEach items="${places}" var="place">
                    <div class="row">
                        <h4 class="trendhead-brand">
                            ${place.getName()}, ${place.getCity().getName()}, ${place.getCity().getCountry().getName()}
                        </h4>
                        <h3 class="trendhead-brand">
                            ${place.getAbout()}
                        </h3>
                    </div>
                    <div class="row">
                        <h3 class="trendhead-brand">
                            <a href="<c:url value='/greeting' />" class="btn btn-success custom-width">Take!</a>
                        </h3>
                    </div>
                    <div class="row">
                        <hr>
                    </div>
                </c:forEach>

                <div class="row">
                    <h3 class="trendhead-brand">
                        <a href="<c:url value='/place/create' />" class="btn btn-success custom-width">Create place</a>
                    </h3>
                </div>
                <c:if test="${user != null && user.role == 'ADMIN'}">AAAAA</c:if>
                ${user}
            </div>

            <div class="trendfoot">
                <jsp:include page="layout/footer.jsp"/>
            </div>
        </div>
    </div>
</div>
</body>
</html>
