<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" />
    <title>Title</title>

</head>
<table id="test-datatable" class="table table-bordered">
    <thead>
    <tr>
        <th scope="col">no</th>
        <th scope="col">제목</th>
        <th scope="col">작성자</th>
        <th scope="col">작성일</th>
        <th scope="col">수정일</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="w" items="${list}" varStatus="vs">
        <tr>
            <th scope="row">${vs.count}</th>
            <td><a href="<%=request.getContextPath() %>/view?no=${w.id}"> ${w.title}</td>
            <td>${w.writer}</td>
            <td>${w.write_time}</td>
            <td>${w.update_time}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

    <a href="/write">글 작성</a>
    <a href="/">뒤로가기</a>
<script>
    $(document).ready( function () {
        $('#test-datatable').DataTable();
    } );
</script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
</body>
</html>
