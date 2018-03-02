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
                <form:form method="GET" action="/fann-statistics/calculate" class="form-horizontal">

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable" for="increment">increment</label>
                            <div class="col-md-7">
                                <form:checkbox path="increment" id="increment" label="increment" class="form-control input-sm" />
                                <div class="has-error">
                                    <form:errors path="increment" class="help-inline"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable" for="batch">batch</label>
                            <div class="col-md-7">
                                <form:checkbox path="batch" id="batch" label="batch" class="form-control input-sm" />
                                <div class="has-error">
                                    <form:errors path="batch" class="help-inline"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-3 control-lable" for="rprop">rprop</label>
                            <div class="col-md-7">
                                <form:checkbox path="rprop" id="rprop" label="rprop" class="form-control input-sm" />
                                <div class="has-error">
                                    <form:errors path="rprop" class="help-inline"/>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit" value="Посчитать статистику" class="btn btn-success btn-sm"/> или
                            <input type="submit" value="Очистить" class="btn btn-success btn-sm"/>

                        </div>
                    </div>
                </form:form>
            </div>

            <div>
<!--todo different statistics results: probably lists to use in js to create graphics-->
            </div>
        </div>
    </div>
</div>
</body>
</html>
