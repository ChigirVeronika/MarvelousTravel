<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
                <form action="/user/get" method="POST">
                    <div class="row">
                        <div class="col-md-3"><label for="email"></label></div>
                        <div class="col-md-5">
                            <input type="text" id="email" placeholder="Email"
                                   name="email" class="form-control">
                        </div>
                        <div class="col-md-4"></div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-2">
                            <input type="submit" value="Найти" class="btn btn-default btn-block"/>
                        </div>
                        <div class="col-md-4"></div>
                    </div>
                    <br>
                </form>
            </div>

            <div class="col-sm-8">
                <div class="row">
                    <h4 class="trendhead-brand">
                        ${user.name} ${user.surname}
                    </h4>

                    <h4  class="trendhead-brand">
                        ${user.passport}
                    </h4>
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
