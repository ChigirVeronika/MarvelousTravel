<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<fmt:setLocale value="ru"/>
<fmt:setBundle basename="i18n.marvelous_travel" var="lang"/>

<html lang="${language}">
<head>
    <jsp:include page="layout/resources.jsp" />
</head>

<body onkeydown="return Disable()">
<div class="site-wrapper">
    <div class="site-wrapper-inner">
        <div class="cover-container">
            <div class="trendhead clearfix">
                <spring:message code="index.login"/>
            </div>

            <div>
                <h1 class="cover-heading"><fmt:message key="index.welcome" bundle="${lang}"/></h1>
                <p class="lead"><fmt:message key="common.take" bundle="${lang}"/></p>
                <p class="lead"><a href="/main?command=menu_command" class="btn btn-lg btn-default"><fmt:message key="index.start" bundle="${lang}"/></a></p>
            </div>
            <br><br><br><br>
            <div class="trendfoot">
                <jsp:include page="layout/footer.jsp"/>
            </div>
        </div>
    </div>
</div>
</body>
</html>