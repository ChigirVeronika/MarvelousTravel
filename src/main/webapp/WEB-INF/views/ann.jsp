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
                        <a href="<c:url value='/ann/train' />" class="btn btn-success custom-width">Train ann</a>
                    </h3>
                    <h3 class="trendhead-brand">
                        ${annTrainMessage}
                    </h3>
                    <h3 class="trendhead-brand">
                        <a href="<c:url value='/ann/work' />" class="btn btn-success custom-width">Run ann</a>
                    </h3>
                    <h3 class="trendhead-brand">
                        ${annWorkMessage}
                    </h3>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
