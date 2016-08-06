<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ include file="/WEB-INF/include/navbar.jsp" %>
<c:url var="createUserUrl" value="/user/save"/>
<div class="container">

    <h1>Create user</h1>

    <div class="row">
        <form action="${createUserUrl}" method="post" role="form" class="form-horizontal">
            <input type="hidden" name="id" value="${user.id}" />
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <div class="form-group">
                <label class="control-label col-sm-2" for="firstName">First name:</label>
                <div class="col-sm-6">
                    <input value="${user.firstName}" name="firstName" type="text" id="firstName" class="form-control" placeholder="Enter first name" autofocus>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="lastName">Last name:</label>
                <div class="col-sm-6">
                    <input value="${user.lastName}" name="lastName" type="text" id="lastName" class="form-control" placeholder="Enter last name" autofocus>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="email">Email:</label>
                <div class="col-sm-6">
                    <input value="${user.email}" name="email" type="text" id="email" class="form-control" placeholder="Enter email" autofocus>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="password">Password:</label>
                <div class="col-sm-6">
                    <input name="password" type="password" id="password" class="form-control" placeholder="Enter password phrase" autofocus>
                </div>
            </div>
            <%--<sec:authorize access="hasRole('ADMIN')">--%>
            <%--<div class="form-group">--%>
                <%--<label class="control-label col-sm-2" for="admin">Admin?:</label>--%>
                <%--<div class="col-sm-6">--%>
                    <%--<select name="admin" type="select" id="admin" class="form-control" placeholder="Admin?" autofocus>--%>
                        <%--<option value="${User.Role.ADMIN}">ADMIN</option>--%>
                        <%--<option value="${User.Role.USER}">USER</option>--%>
                    <%--</select>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--</sec:authorize>--%>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <button type="submit" class="btn btn-primary">Save</button>
                    <a href="${usersUrl}" class="btn btn-danger">Cancel</a>
                </div>
            </div>
        </form>
    </div>

</div>

<%@ include file="/WEB-INF/include/footer.jsp" %>