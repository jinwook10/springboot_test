<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="mem" items="${tmlist }">
		${mem.mem_name}
		</br>
		${mem.mem_age}
		</br>
		${mem.mem_id}
	</c:forEach>
	</br>
	</br>
	<c:forEach var="mem" items="${amlist }">
		${mem.mem_name}
		</br>
		${mem.mem_age}
		</br>
		${mem.mem_id}
	</c:forEach>
</body>
</html>