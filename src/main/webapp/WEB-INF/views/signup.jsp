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
    <link rel="apple-touch-icon" sizes="57x57" href="/assets/coreui/favicon/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="/assets/coreui/favicon/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="/assets/coreui/favicon/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="/assets/coreui/favicon/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="/assets/coreui/favicon/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="/assets/coreui/favicon/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="/assets/coreui/favicon/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="/assets/coreui/favicon/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="/assets/coreui/favicon/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192" href="/assets/coreui/favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/assets/coreui/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="/assets/coreui/favicon/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/assets/coreui/favicon/favicon-16x16.png">
    <link rel="manifest" href="/assets/coreui/favicon/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="/assets/coreui/favicon/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">
    <!-- Vendors styles-->
    <link rel="stylesheet" href="/vendors/coreui/simplebar/css/simplebar.css">
    <link rel="stylesheet" href="/css/coreui/vendors/simplebar.css">
    <!-- Main styles for this application-->
    <link href="/css/coreui/style.min.css" rel="stylesheet">
    <!-- We use those styles to show code examples, you should remove them in your application.-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/prismjs@1.23.0/themes/prism.css">
    <link href="/css/coreui/examples.min.css" rel="stylesheet">
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
                    <svg class="icon">
                      <use xlink:href="/vendors/coreui/@coreui/icons/svg/free.svg#cil-user"></use>

                    </svg></span>
                                <input class="form-control" type="text" placeholder="Username" name="username">
                            </div>

                            <div class="input-group mb-3"><span class="input-group-text">
                    <svg class="icon">
                      <use xlink:href="/vendors/coreui/@coreui/icons/svg/free.svg#cil-lock-locked"></use>
                    </svg></span>
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
<script src="/vendors/coreui/simplebar/js/simplebar.min.js"></script>
<!-- Plugins and scripts required by this view-->

<script src="/vendors/coreui/@coreui/utils/js/coreui-utils.js"></script>
<script src="/js/coreui/main.js"></script>

</body>
</html>