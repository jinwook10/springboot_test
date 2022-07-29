<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 공간입니다.</title>
</head>
<body>
	관리자 페이지입니다
    <c:if test="${not empty pageContext.request.userPrincipal }">
        <p> ${pageContext.request.userPrincipal.name} 으로 로그인 되어있는중 </p>
    </c:if>
    <a href="/admin/notice">공지사항 관리</a>
</body>
</html>