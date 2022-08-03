<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome page</title>
</head>
<body>
	Welcome
    <c:if test="${not empty pageContext.request.userPrincipal }">
        <p> ${pageContext.request.userPrincipal.principal.name} 으로 로그인 되어있는중 </p>
    </c:if>
    <br>
    <a href="/admin/adminpage">관리자 페이지 이동</a>
    <a href="/board">게시판 이동</a>
    <a href="/signup">회원 가입 이동</a>
</body>
</html>