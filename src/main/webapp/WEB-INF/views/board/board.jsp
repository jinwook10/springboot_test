<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Title</title>

</head>
<body>
<div class="editor"></div>
<table class="table">
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
        <td><a href="<%=request.getContextPath() %>/view?no=${w.id}">${w.title}</td>
        <td>${w.writer}</td>
        <td>${w.write_time}</td>
        <td>${w.update_time}</td>
    </tr>
    </c:forEach>
    </tbody>
    <a href="/write">글 작성</a>
</table>
</body>
</html>
