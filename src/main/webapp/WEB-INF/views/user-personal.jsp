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
                    <form:form method="POST" modelAttribute="userDto" class="form-horizontal" id="userUpdateForm">

                        <form:input type="hidden" path="id" id="id"/>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="name">Name</label>
                                <div class="col-md-7">
                                    <form:input type="text" path="name" id="name" class="form-control input-sm" disabled="true"/>
                                    <div class="has-error">
                                        <form:errors path="name" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="surname">Surname</label>
                                <div class="col-md-7">
                                    <form:input type="text" path="surname" id="surname" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="surname" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="birthday">Birthday</label>
                                <div class="col-md-7">
                                    <form:input type="date" path="birthday" id="birthday" class="form-control input-sm" pattern="MM/dd/yyyy" disabled="true"/>
                                    <div class="has-error">
                                        <form:errors path="birthday" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="passport">Passport</label>
                                <div class="col-md-7">
                                    <form:input type="text" path="passport" id="passport" class="form-control input-sm" disabled="true"/>
                                    <div class="has-error">
                                        <form:errors path="passport" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="phone">Phone</label>
                                <div class="col-md-7">
                                    <form:input type="text" path="phone" id="phone" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="phone" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-3 control-lable" for="maritalStatus">Marital status</label>
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
                                <label class="col-md-3 control-lable" for="email">Email</label>
                                <div class="col-md-7">
                                    <form:input type="text" path="email" id="email" class="form-control input-sm" disabled="true"/>
                                    <div class="has-error">
                                        <form:errors path="email" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="password">Password</label>
                                <div class="col-md-7">
                                    <form:input type="text" path="password" id="password" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="password" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-3 control-lable" for="income">Income</label>
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
                              <label class="col-md-3 control-lable" for="isParent">Are you a parent?</label>
                              <div class="col-md-7">
                                  <form:checkbox path="isParent" id="isParent" label="Parent" class="form-control input-sm" />
                                  <div class="has-error">
                                      <form:errors path="isParent" class="help-inline"/>
                                  </div>
                              </div>
                          </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-3 control-lable" for="home">Home</label>
                                <div class="col-md-7">
                                    <form:select path="home" id="home">
                                        <c:forEach var='city' items='${cities}' varStatus='loop' >
                                            <form:option value="${city}" label="${city.name}" />
                                        </c:forEach>
                                    </form:select>
                                    <div class="has-error">
                                        <form:errors path="home" class="help-inline"/>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="row">
                            <div class="form-actions floatRight">
                                <input type="submit" value="Update" class="btn btn-success btn-sm"/>
                                <input type="submit" value="Reset" class="btn btn-warning btn-sm" onclick="return clear();"/>
                            </div>
                        </div>

                        <script type="text/javascript">
                            function clear() {
                                document.getElementById("userUpdateForm").reset();
                            }
                        </script>
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
