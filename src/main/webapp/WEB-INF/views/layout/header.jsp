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
            <li><a href="../index.jsp"><fmt:message key="header.home" bundle="${lang}"/></a> </li>

            <li><a href="/main?command=menu_command"><fmt:message key="header.catalog" bundle="${lang}"/></a></li>

            <li><a href="<c:url value='/news/list' />"><fmt:message key="header.news" bundle="${lang}"/></a></li>

            <li><a href="../order.jsp"><spring:message code="header.news"/></a></li>

            <c:if test="${user != null && user.role == 'ADMIN'}">
                <li><a href="../users.jsp"><fmt:message key="header.users" bundle="${lang}"/></a></li>
            </c:if>

            <c:if test="${user == null}">
                <li><a href="../login.jsp"><fmt:message key="header.login" bundle="${lang}"/></a></li>
            </c:if>

            <c:if test="${user != null}">
                <li><a href="/main?command=logout_command"><fmt:message key="header.logout" bundle="${lang}"/></a></li>
            </c:if>

        </ul>
    </nav>
</div>