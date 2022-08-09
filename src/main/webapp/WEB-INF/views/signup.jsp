<!DOCTYPE html>
<!--
* CoreUI - Free Bootstrap Admin Template
* @version v4.2.0
* @link https://coreui.io
* Copyright (c) 2022 creativeLabs Łukasz Holeczek
* Licensed under MIT (https://coreui.io/license)
-->
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>메인 페이지</title>
    <!-- Main styles for this application-->
    <link href="/css/coreui/style.min.css" rel="stylesheet">
</head>
<body>
<div class="bg-light min-vh-100 d-flex flex-row align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card mb-4 mx-4">
                    <form method="post" action="/signup">
                        <div class="card-body p-4">
                            <h1>회원가입</h1>
                            <p class="text-medium-emphasis">정보를 입력해 주세요</p>
                            <div class="input-group mb-3"><span class="input-group-text">
                    </span>
                                <input class="form-control" type="text" placeholder="Username" name="username">
                            </div>

                            <div class="input-group mb-3"><span class="input-group-text">
                    </span>
                                <input class="form-control" type="password" placeholder="Password" name="password">
                            </div>

                            <button class="btn btn-block btn-success" type="submit">가입하기</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- CoreUI and necessary plugins-->
<script src="/vendors/coreui/@coreui/coreui/js/coreui.bundle.min.js"></script>

<%--<script src="/vendors/coreui/@coreui/utils/js/coreui-utils.js"></script>--%>

</body>
</html>