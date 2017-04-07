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
                <div class="row">
                    <form:form method="POST" modelAttribute="feedback" class="form-horizontal">
                        <form:input type="hidden" path="id" id="id"/>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="content">Отзыв</label>
                                <div class="col-md-7">
                                    <form:input type="text" path="content" id="content" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="content" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="mark">Оценка</label>
                                <div class="col-md-7">
                                    <form:input type="text" path="mark" id="mark" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="mark" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-actions floatRight">
                                <input type="submit" value="Оставить отзыв" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/feedback/list' />">Отменить</a>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>

            <div class="col-sm-8">

                <c:forEach items="${feedbacks}" var="feedback">
                    <div class="row">
                        <h4 class="trendhead-brand">
                            ${feedback.user}
                        </h4>
                    </div>
                    <div class="row">
                        <h5 class="trendhead-brand">Дата: ${feedback.date}</h5>
                    </div>
                    <div class="row">
                        <h5 class="trendhead-brand">Оценка: ${feedback.mark}</h5>
                    </div>
                    <div class="row">
                        <h5 class="trendhead-brand">${feedback.content}</h5>
                    </div>
                    <div class="row">
                        <hr>
                    </div>
                </c:forEach>

            </div>

            <div class="trendfoot">
                <jsp:include page="layout/footer.jsp"/>
            </div>
        </div>
    </div>
</div>
</body>
</html>
