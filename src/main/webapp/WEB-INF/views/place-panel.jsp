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
            <div class="col-sm-8">
                <div class="row">
                    <form method="POST"  action="panel" class="form-horizontal" id="tourPanelForm">
                        <div class="row">
                            <div class="col-md-5">
                                <input type="text" id="about" placeholder="About" name="about" class="form-control">
                            </div>
                            <div class="col-md-4"></div>
                        </div>

                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-md-2">
                                <input type="submit" value="Search" class="btn btn-default btn-block"/>
                            </div>
                            <div class="col-md-4"></div>
                        </div>

                        <script type="text/javascript">
                            function clear() {
                                document.getElementById("tourPanelForm").reset();
                            }
                        </script>
                    </form>
                </div>

                <div class="row">
                    <c:forEach items="${places}" var="place">
                        <div class="row">
                            <h4 class="trendhead-brand">
                                ${place.getName()}, ${place.getCityName()}
                            </h4>
                            <h3 class="trendhead-brand">
                                ${place.getRating()}
                            </h3>
                            <h3 class="trendhead-brand">
                                ${place.getAbout()}
                            </h3>
                        </div>
                        <div class="row">
                            Set rate:
                            <form method="POST"  action="rate" class="form-horizontal" id="ratePanelForm">
                                <input type="hidden" id="placeId" name="placeId" value="${place.getId()}">
                                <div class="row">
                                    <div class="col-md-5">
                                        <input type="text" id="mark" placeholder="Mark" name="mark" class="form-control">
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-3"></div>
                                    <div class="col-md-2">
                                        <input type="submit" value="Submit" class="btn btn-default btn-block"/>
                                    </div>
                                </div>

                                <script type="text/javascript">
                                    function clear() {
                                        document.getElementById("ratePanelForm").reset();
                                    }
                                </script>
                            </form>
                        </div>
                    </c:forEach>
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
