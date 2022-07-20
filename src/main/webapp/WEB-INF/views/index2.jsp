<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	인덱스 jsp입니다.
	</br>
<%-- 	<c:if test="${not empty mist}"> --%>
		<c:forEach var="mem" items="${mlist}">
			<tr>
				<td>${mem.name}</td>
				<td>${mem.id}</td>
				<td>${mem.age}</td>
			</tr>
		</c:forEach>
<%-- 	</c:if> --%>
</body>
</html>