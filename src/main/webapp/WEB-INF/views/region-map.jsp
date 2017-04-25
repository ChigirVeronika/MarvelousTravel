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
            <div class="inner cover">
            <div class="col-sm-8">

                <table>
                    <c:forEach items="${map}" var="mapElement">
                    <div class="row">
                        <tr>
                            <td><h4>${mapElement.key.getName()}</h4></td>
                        </tr>
                        <tr>
                            <c:forEach items="${mapElement.value}" var="listElement">
                                <td><h6><a href="<c:url value='/country/get/${listElement.getId()}' />">${listElement.getName()}</a></h6></td>
                            </c:forEach>

                        </tr>
                    </div>
                    </c:forEach>
                </table>

                <div class="row">
                    <h3 class="trendhead-brand">
                        <a href="<c:url value='' />" class="btn btn-success custom-width">Регион</a>
                    </h3>
                </div>
            </div>
            </div>


        </div>
    </div>
</div>
</body>
</html>
