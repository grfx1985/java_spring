<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="booksUrl" value="/books"/>
<c:url var="createUserUrl" value="/user/create"/>

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
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Users <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">New...</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Show all</a></li>
                    </ul>
                </li>
                <li><a href="#">Books</a></li>
                <li><a href="#">My rents</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Wojciech <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">My account</a></li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a href="#">Logout</a>

                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>