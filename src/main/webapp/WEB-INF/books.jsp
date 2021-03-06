<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ include file="/WEB-INF/include/navbar.jsp" %>
<c:url var="editBookUrl" value="/book/edit"/>
<c:url var="deleteBookUrl" value="/book/delete"/>
<c:url var="rentBookUrl" value="/rent/book"/>
<div class="container">

    <h1>List of books</h1>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-hover table-bordered">
                <thead>
                <tr>
                    <th class="text-center col-md-1">Id</th>
                    <th class="text-center">Title</th>
                    <th class="text-center">Author</th>
                    <th class="text-center col-md-1">Available</th>
                    <th class="text-center col-md-1">Action</th>
                    <th class="text-center col-md-1">Edit</th>
                    <th class="text-center col-md-1">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${bookList}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.available}</td>
                    <c:if test="${book.available != 0}">
                    <td class="text-center"><a href="${rentBookUrl}/${book.id}" class="btn btn-sm btn-info rent-book">Rent</a></td>
                    </c:if>
                    <c:if test="${book.available == 0}">
                        <td class="text-center"><a href="${rentBookUrl}/${book.id}" class="btn btn-sm btn-default disabled">Rent</a></td>
                    </c:if>
                    <td class="text-center"><a href="${editBookUrl}/${book.id}" class="btn btn-sm btn-success">Edit</a></td>
                    <td class="text-center"><a href="${deleteBookUrl}/${book.id}" class="btn btn-sm btn-danger delete-button">Delete</a></td>
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
        $('.rent-book').on('click', function(event) {
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