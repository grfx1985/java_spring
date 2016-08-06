<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ include file="/WEB-INF/include/navbar.jsp" %>
<c:url var="returnUrl" value="/rent/return"/>
<c:url var="deleteReturnUrl" value="/rent/delete"/>
<div class="container">

    <h1>List of Rents</h1>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th class="text-center col-md-1">Id</th>
                    <th class="text-center">Date Rent</th>
                    <th class="text-center">Date Return</th>
                    <th class="text-center">User</th>
                    <th class="text-center">Book</th>
                    <th class="text-center col-md-1">Return Book Action</th>
                    <sec:authorize access="hasRole('ADMIN')">
                    <th class="text-center col-md-1">Remove</th>
                    </sec:authorize>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="rent" items="${rents}">
                    <tr>
                        <td>${rent.id}</td>
                        <td>${rent.rentDate}</td>
                        <td>${rent.returnDate}</td>
                        <td>${rent.user.firstName}  ${rent.user.lastName}</td>
                        <td>${rent.book.title} (${rent.book.author})</td>
                        <c:if test="${rent.returnDate != null}">
                            <td class="text-center"><a href="${returnUrl}/${rent.id}" class="btn btn-sm btn-default disabled">Return Book</a></td>
                        </c:if>
                        <c:if test="${rent.returnDate == null}">
                            <td class="text-center"><a href="${returnUrl}/${rent.id}" class="btn btn-sm btn-success return-button">Return Book</a></td>
                        </c:if>
                        <sec:authorize access="hasRole('ADMIN')">
                        <td class="text-center"><a href="${deleteReturnUrl}/${rent.id}" class="btn btn-sm btn-success delete-button">Delete</a></td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
<%--// $(document).ready(function() {
//
// });--%>
<script>
    $(function() {
        $('.delete-button').on('click', function(event) {
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

    $(function() {
        $('.return-button').on('click', function(event) {
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
<%@ include file="/WEB-INF/include/footer.jsp" %>