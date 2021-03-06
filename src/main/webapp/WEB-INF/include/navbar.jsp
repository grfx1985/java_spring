<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:url var="booksUrl" value="/books"/>
<c:url var="createBookUrl" value="/book/create"/>


<c:url var="createUserUrl" value="/user/create"/>
<c:url var="logoutUserUrl" value="/logout"/>

<c:url var="usersUrl" value="/users"/>
<c:url var="rentsUrl" value="/rents"/>


<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"></a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <%--  rola admin widzi userow  --%>
                <sec:authorize access="hasRole('ADMIN')">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Users <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${createUserUrl}">New...</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${usersUrl}">Show all</a></li>
                    </ul>
                </li>
                </sec:authorize>
                <li class="dropdown" >
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Books <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${createBookUrl}">Add new...</a></li>
                        <li role="separator" class="divider"> </li>
                        <li><a href="${booksUrl}">Show all</a></li>
                    </ul>
                <li><a href="${rentsUrl}">My rents</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><sec:authentication property="principal.username"/><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">My account</a></li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a class="logout-button" href="${logoutUserUrl}">Logout</a>

                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<script>
    $(function() {
        $('.logout-button').on('click', function(event) {
            console.log(event);
            event.preventDefault();
            var url = event.target.href;
            $.post(url,{
                '${_csrf.parameterName}' : '${_csrf.token}'
            })
                    .done(function(){
                        location.reload();
                    });
        });
    });
</script>