<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome page</title>
    <link rel="stylesheet" type="text/css" href="/css/coreui/coreui.min.css">
    <style>
        .card{
            background-color:orangered;
        }
    </style>
</head>
<body>
<div class="bg-light min-vh-100 d-flex flex-row align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card mb-4 mx-4">
                    <div class="card-body p-4">
                        <div class="card-body text-center">
                            <div >
                                <h2>Welcome</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                <c:if test="${not empty pageContext.request.userPrincipal }">
                                    <p>${pageContext.request.userPrincipal.principal.name} 으로 로그인 되어있는중</p>
                                </c:if>
                                <button class="btn btn-lg btn-outline-light mt-3" type="button" onclick="location.href='/board'">게시판 이동</button>
                                <button class="btn btn-lg btn-outline-light mt-3" type="button" onclick="location.href='/signup'">회원가입</button>
                                <button class="btn btn-lg btn-outline-light mt-3" type="button" onclick="location.href='/admin/adminpage'">관리자 페이지 이동</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="vendors/@coreui/coreui/js/coreui.bundle.min.js"></script>
<script src="vendors/simplebar/js/simplebar.min.js"></script>
</body>
</html>