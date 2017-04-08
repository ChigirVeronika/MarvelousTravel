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

                <c:forEach items="${tours}" var="tour">
                    <div class="row">
                        <h4 class="trendhead-brand">
                            ${tour.name}
                        </h4>
                    </div>
                    <div class="row">
                        <h5>Даты: ${tour.startDate} - {tour.endDate} // Суток: </h5>
                    </div>
                    <div class="row">
                        <h5>Маршрут: ${tour.cityFrom} - {tour.cityTo}</h5>
                    </div>
                    <div class="row">
                        <h5>Цена: ${tour.price} рублей</h5>
                    </div>
                    <div class="row">
                        <h3 class="trendhead-brand">
                            <a href="<c:url value='/tour/get/${tour.id}' />" class="btn btn-success custom-width">Беру!</a>
                        </h3>
                    </div>
                    <div class="row">
                        <hr>
                    </div>
                </c:forEach>

                <div class="row">
                    <h3 class="trendhead-brand">
                        <a href="<c:url value='/tour/create' />" class="btn btn-success custom-width">Новость</a>
                    </h3>
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
