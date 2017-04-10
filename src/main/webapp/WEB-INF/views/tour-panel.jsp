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

                    <form:form method="POST" modelAttribute="tour" class="form-horizontal">


                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="startDate">С</label>
                                <div class="col-md-7">
                                    <form:input type="date" path="startDate" id="startDate" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="startDate" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="startDate">По</label>
                                <div class="col-md-7">
                                    <form:input type="date" path="endDate" id="endDate" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="endDate" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="cityFrom">Откуда</label>
                                <div class="col-md-7">
                                    <form:select path="cityFrom" id="cityFrom" class="form-control input-sm">
                                        <form:option value="NONE" label="--- Select ---"/>
                                        <c:forEach var="item" items="${cities}">
                                            <form:option value="${item}" label="${item.name}"/>
                                        </c:forEach>
                                    </form:select>
                                    <div class="has-error">
                                        <form:errors path="cityFrom" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="cityFrom">Куда</label>
                                <div class="col-md-7">
                                    <form:select path="cityTo" id="cityTo" class="form-control input-sm">
                                        <form:option value="NONE" label="--- Select ---"/>
                                        <c:forEach var="item" items="${cities}">
                                            <form:option value="${item}" label="${item.name}"/>
                                        </c:forEach>
                                    </form:select>
                                    <div class="has-error">
                                        <form:errors path="cityTo" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-actions floatRight">
                                <input type="submit" value="Найти" class="btn btn-primary btn-sm"/> или <a href="<c:url value='/main' />">Отменить</a>
                            </div>
                        </div>
                    </form:form>

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
