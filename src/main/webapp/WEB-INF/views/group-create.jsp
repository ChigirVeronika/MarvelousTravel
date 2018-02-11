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
                    <form:form method="POST" modelAttribute="groupDto" class="form-horizontal">

                        <form:input type="hidden" path="id" id="id"/>
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="name">Название</label>
                                <div class="col-md-7">
                                    <form:input type="text" path="name" id="name" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="name" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="info">Описание</label>
                                <div class="col-md-7">
                                    <form:input type="text" path="info" id="info" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="info" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="age">Возраст</label>
                                <div class="col-md-7">
                                    <form:input type="text" path="age" id="age" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="age" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="gender">Пол</label>
                                <div class="col-md-7">
                                    <form:radiobutton path="gender" id="gender" value="M" label="M" />
                                    <form:radiobutton path="gender" id="gender" value="F" label="F" />
                                    <div class="has-error">
                                        <form:errors path="gender" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="maritalStatus">Статус брака</label>
                                <div class="col-md-7">
                                    <form:checkbox path="maritalStatus" id="maritalStatus" label="Married" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="maritalStatus" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="income">Доход</label>
                                <div class="col-md-7">
                                    <form:input type="text" path="income" id="income" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="income" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="isParent">Дети</label>
                                <div class="col-md-7">
                                    <form:checkbox path="isParent" id="isParent" label="Parent" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="isParent" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-actions floatRight">
                                <input type="submit" value="Создать" class="btn btn-success btn-sm"/> или
                                <input type="submit" value="Очистить" class="btn btn-success btn-sm"/>

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
