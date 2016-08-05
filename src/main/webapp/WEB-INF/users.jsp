<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ include file="/WEB-INF/include/navbar.jsp" %>
<c:url var="editUserUrl" value="/user/edit"/>
<c:url var="deleteUserUrl" value="/user/delete"/>
<div class="container">

    <h1>List of Users</h1>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th class="text-center col-md-1">Id</th>
                    <th class="text-center">Email</th>
                    <th class="text-center col-md-1">Edit</th>
                    <th class="text-center col-md-1">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${userList}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.email}</td>
                        <td class="text-center"><a href="${editUserUrl}/${user.id}" class="btn btn-sm btn-success">Edit</a></td>
                        <td class="text-center"><a href="${deleteUserUrl}/${user.id}" class="btn btn-sm btn-danger delete-button">Delete</a></td>
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
</script>
<%@ include file="/WEB-INF/include/footer.jsp" %>