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
                    <h4 class="trendhead-brand">
                        ${country.name}
                    </h4>
                </div>
                </br>
                <div class="row">
                    <h4 class="trendhead-brand">About</h4>
                    <p><h5>${country.about}</h5></p>
                </div>
                <div class="row">
                    <h4 class="trendhead-brand">Cities</h4>
                    <p>
                    <h5>
                        <c:forEach items="${country.cities}" var="city">
                            ${city.name}<br>
                        </c:forEach>
                    </h5>
                    </p>
                </div>
            </div>
            <div class="trendfoot">
                <jsp:include page="layout/footer.jsp"/>
            </div>
        </div>
    </div>
</div>
</body>
</html>
