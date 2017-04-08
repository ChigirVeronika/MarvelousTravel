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
                <div class="inner">
                    <h3 class="trendhead-brand">
                        <fmt:message key="header.title" bundle="${lang}"/>
                    </h3>
                    <nav>
                        <ul class="nav trendhead-nav">
                            <li></li>
                        </ul>
                    </nav>
                </div>
            </div>

            <div class="inner cover">
                <form action="login" method="POST">
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
                        <div class="col-md-3"><label for="password"></label></div>
                        <div class="col-md-5">
                            <input type="password" id="password" name="password" class="form-control"
                                   placeholder="<fmt:message key="login.password" bundle="${lang}"/>"/>
                        </div>
                        <div class="col-md-4"></div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="col-md-3"></div>
                        <div class="col-md-2">
                            <!--<button type="submit">Login</button>-->
                            <input type="submit" value="<fmt:message key="login.signin" bundle="${lang}"/>"
                                   class="btn btn-default btn-block"/>
                        </div>
                        <div class="col-md-3">
                             <a href="<c:url value='/main' />" class="btn btn-default btn-block"><fmt:message key="login.signup"
                                                                                              bundle="${lang}"/></a>
                        </div>
                        <div class="col-md-4"></div>
                    </div>
                    <br>
                </form>
            </div>

            <div class="trendfoot">
                <jsp:include page="layout/footer.jsp"/>
            </div>

        </div>
    </div>
</div>
</body>

</html>
