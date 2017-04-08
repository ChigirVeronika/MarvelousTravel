<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<fmt:setLocale value="ru_RU"/>
<fmt:setBundle basename="i18n.marvelous_travel" var="lang"/>

<div class="inner">
    <h3 class="trendhead-brand">
        <fmt:message key="header.title" bundle="${lang}"/>
    </h3>
    <nav>
        <ul class="nav trendhead-nav">
            <li><a href="<c:url value='/main' />"><spring:message code="header.home"/></a> </li>

            <li><a href="<c:url value='/region/map' />"><spring:message code="header.counrties"/></a></li>

            <li><a href="<c:url value='/tour/panel' />"><spring:message code="header.findtour"/></a></li>

            <li><a href="<c:url value='/news/list' />"><spring:message code="header.news"/></a></li>

            <li><a href="<c:url value='/feedback/list' />"><spring:message code="header.feedback"/></a></li>

            <li><a href="<c:url value='/google/map' />">Карта</a></li>


            <c:if test="${user != null && user.role == 'ADMIN'}">
                <li><a href="<c:url value='/user/list' />"><spring:message code="header.users"/></a></li>
                <li><a href="<c:url value='/statistics/list' />"><spring:message code="header.statistics"/></a></li>
            </c:if>

            <c:if test="${user != null}">
                <li><a href="<c:url value='/logout' />"><fmt:message key="header.logout" bundle="${lang}"/></a></li>
            </c:if>

        </ul>
    </nav>
</div>