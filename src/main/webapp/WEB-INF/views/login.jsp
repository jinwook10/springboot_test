<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta charset="UTF-8">
    <title>welcome page</title>
    <link rel="stylesheet" href="/css/coreui/coreui.min.css">
</head>
<body>
<div class="bg-light min-vh-100 d-flex flex-row align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div class="card-group d-block d-md-flex row">
                    <div class="card col-md-7 p-4 mb-0">
                        <form method="post" action="/login">
                        <div class="card-body">
                            <h1 style="color: black">로그인</h1>
                            <div class="input-group mb-3"><span class="input-group-text">

                                <input class="form-control" type="text" name="username" placeholder="아이디">
                            </div>
                            <div class="input-group mb-4"><span class="input-group-text">

                                <input class="form-control" type="password" name="password" placeholder="비밀번호">
                            </div>
                            <div class="row">
                                <div class="col-6">
                                    <button class="btn btn-primary px-4" type="submit">로그인</button>
                                </div>
                            </div>
                        </div>
                        </form>
                    </div>
                    <div class="card col-md-5 text-white bg-primary py-5">
                        <div class="card-body text-center">
                            <div>
                                <h2>환영합니다!</h2>
                                <p>테스트 홈페이지에 오신것을 환영합니다.</p>
                                <button class="btn btn-lg btn-outline-light mt-3" type="button" onclick="location.href='/signup'">회원 가입</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/js/coreui/coreui.bundle.min.js"></script>
<script src="/js/coreui/coreui.esm.min.js"></script>
<script src="/js/coreui/coreui-utilities.min.js"></script>

</body>
</html>