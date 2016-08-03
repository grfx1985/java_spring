<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/header.jsp" %>
<%@ include file="/WEB-INF/include/navbar.jsp" %>

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
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>aa</td>
                    <td>aabb</td>
                    <td>6</td>
                    <td class="text-center"><a class="btn btn-sm btn-primary">Rent</a></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>aa</td>
                    <td>aabb</td>
                    <td>10</td>
                    <td class="text-center"><a class="btn btn-sm btn-primary">Rent</a></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

</div>
<%@ include file="/WEB-INF/include/footer.jsp" %>