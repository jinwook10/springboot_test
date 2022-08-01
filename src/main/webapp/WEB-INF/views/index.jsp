<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome page</title>
</head>
<body>
	Welcome
    <c:if test="${not empty pageContext.request.userPrincipal }">
        <p> ${pageContext.request.userPrincipal.name} 으로 로그인 되어있는중 </p>
    </c:if>
    <a href="/admin/adminpage">관리자 페이지 이동</a>
    <a href="/signup">회원 가입 이동</a>
</body>
</html>