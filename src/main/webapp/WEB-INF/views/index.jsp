<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome page</title>
    <link rel="stylesheet" type="text/css" href="/css/coreui/coreui.min.css">
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
                                <button class="btn btn-lg btn-outline-light mt-4" type="button">Register Now!</button>
                                <button class="btn btn-lg btn-outline-light mt-3" type="button">Register Now!</button>
                                <button class="btn btn-lg btn-outline-light mt-3" type="button">Register Now!</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="bg-light min-vh-100 d-flex flex-row align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div class="card-group d-block d-md-flex row">
                    <div class="card col-md-5 text-white bg-primary py-5">
                        <div class="card-body text-center">
                            <div >
                                <h2>Welcome</h2>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
                                <c:if test="${not empty pageContext.request.userPrincipal }">
                                    <p>${pageContext.request.userPrincipal.principal.name} 으로 로그인 되어있는중</p>
                                </c:if>
                                <button class="btn btn-lg btn-outline-light mt-4" type="button">Register Now!</button>
                                <button class="btn btn-lg btn-outline-light mt-3" type="button">Register Now!</button>
                                <button class="btn btn-lg btn-outline-light mt-3" type="button">Register Now!</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

    <a href="/admin/adminpage">관리자 페이지 이동</a>
    <a href="/board">게시판 이동</a>
    <a href="/signup">회원 가입 이동</a>
<script src="vendors/@coreui/coreui/js/coreui.bundle.min.js"></script>
<script src="vendors/simplebar/js/simplebar.min.js"></script>
</body>
</html>