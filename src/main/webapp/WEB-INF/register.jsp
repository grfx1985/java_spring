<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/header.jsp" %>
<c:url var="createUserUrl" value="/register"/>
<c:url var="loginUrl" value="/login"/>
<div class="container">
    <div class="card card-container">
        <h4> Create new account</h4>
        <form action="${createUserUrl}" method="post"  class="form-signin">
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
            <input name="firstName" type="text" id="inputFirstName" class="form-control" placeholder="First name" required>
            <input name="lastName" type="text" id="inputLastName" class="form-control" placeholder="Last name" required>
            <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <input name="repeatPassword"  type="password" id="inputRepeatedPassword" class="form-control" placeholder="Repeat password" required>

            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Create</button>
        </form>
        <div class="margin-bottom-10">
            <a href="${loginUrl}" class="forgot-password">Back to login</a>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/include/footer.jsp" %>