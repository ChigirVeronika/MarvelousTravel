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
                    <c:forEach items="${countries}" var="country">
                    <div class="row">
                        <tr>
                        <td><a href="<c:url value='/country/get/${country.getId()}' />">${country.getName()}</a></td>
                        </tr>
                    </div>
                    </c:forEach>
                </table>
            </div>
            </div>


        </div>
    </div>
</div>
</body>
</html>
