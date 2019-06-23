<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
                <jsp:include page="layout/header.jsp" />
            </div>
            <div>
                <a href="<c:url value='/login' />">Login</a>
                <c:forEach items="${places}" var="place">
                    <div class="row">
                        <tr>
                            <td>${place.getName()}</td>
                        </tr>
                    </div>
                </c:forEach>
                <br>
                <c:forEach items="${tags}" var="tag">
                    <div class="row">
                        <tr>
                            <td>${tag.getName()}</td>
                        </tr>
                    </div>
                </c:forEach>

                <form action="addMain" method="POST">
                    <table>
                        <tr>
                            <td>Choose places you like:</td>
                            <c:forEach var="place" items="${places}">
                                <td><input type="checkbox" name="placeIds" value="${place.id}" checked="checked" /> <c:out value = "${place.name}" /></td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <td>Choose tags you like:</td>
                            <c:forEach var="tag" items="${tags}">
                                <td><input type="checkbox" name="tagIds" value="${tag.id}" checked="checked" /> <c:out value = "${tag.name}" /></td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <td><input type="submit" name="submit" value="Submit"></td>
                        </tr>
                        <tr>
                    </table>
                </form>
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