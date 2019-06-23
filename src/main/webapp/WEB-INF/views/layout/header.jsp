<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<fmt:setLocale value="ru_RU"/>
<fmt:setBundle basename="i18n.marvelous_travel" var="lang"/>

<div class="inner">
    <h3 class="trendhead-brand">
        Marvelous Travel
    </h3>
    <nav>
        <ul class="nav trendhead-nav">
            <li><a href="<c:url value='/main' />">Recommendations</a></li>
            <li><a href="<c:url value='/country/list' />">Countries</a></li>
            <li><a href="<c:url value='/place/list' />">Places</a></li>
            <li><a href="<c:url value='/news/list' />">News</a></li>
            <li><a href="<c:url value='/google/map' />">Map</a></li>
            <li><a href="<c:url value='/user/list' />">Users</a></li>
            <li><a href="<c:url value='/user/get' />">Find User</a></li>
            <li><a href="<c:url value='/statistics/list' />">Statistics</a></li>
        </ul>
    </nav>
</div>