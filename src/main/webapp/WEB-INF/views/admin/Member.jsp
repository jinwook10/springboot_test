<!DOCTYPE html>

<html lang="en">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>메인 페이지</title>
    <link rel="stylesheet" href="/css/coreui/css/simplebar.css">
    <!-- Main styles for this application-->
    <link href="/css/coreui/css/style.min.css" rel="stylesheet">
    <link href="/css/coreui/css/free.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css"/>

</head>
<body>
<div class="sidebar sidebar-dark sidebar-fixed" id="sidebar">
    <div class="sidebar-brand d-none d-md-flex">
        <svg class="sidebar-brand-full" width="118" height="46" alt="CoreUI Logo">
            <use xlink:href="assets/brand/coreui.svg#full"></use>
        </svg>
        <svg class="sidebar-brand-narrow" width="46" height="46" alt="CoreUI Logo">
            <use xlink:href="assets/brand/coreui.svg#signet"></use>
        </svg>
    </div>
    <ul class="sidebar-nav" data-coreui="navigation" data-simplebar="">
        <li class="nav-title">메뉴</li>
        <li class="nav-group"><a class="nav-link nav-group-toggle" href="#">
            <i class="icon icon-2xl cil-aperture"></i>페이지</a>
            <ul class="nav-group-items">

                <li class="nav-item"><a class="nav-link" href="/board" target="_top">
                    <i class="icon icon-2xl cil-animal"></i>게시판</a></li>
            </ul>
        </li>
    </ul>
    <button class="sidebar-toggler" type="button" data-coreui-toggle="unfoldable"></button>
</div>
<div class="wrapper d-flex flex-column min-vh-100 bg-light">
    <header class="header header-sticky mb-4">
        <div class="container-fluid">
            <button class="header-toggler px-md-0 me-md-3" type="button" onclick="coreui.Sidebar.getInstance(document.querySelector('#sidebar')).toggle()">
                <i class="icon icon-2xl cil-apps"></i>
            </button>
            <ul class="header-nav d-none d-md-flex">
                <li class="nav-item"><a class="nav-link" href="/">메인 화면</a></li>
                <li class="nav-item"><a class="nav-link" href="/board">게시판</a></li>
                <li class="nav-item"><a class="nav-link" href="/admin/adminpage">관리자 설정</a></li>
            </ul>
            <ul class="header-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="">
                    <i class="icon icon-2xl cil-eco"></i></a></li>
                <li class="nav-item"><a class="nav-link" href="">
                    <i class="icon icon-2xl cil-diamond"></i></a></li>
                <li class="nav-item"><a class="nav-link" href="">
                    <i class="icon icon-2xl cil-bell"></i></a></li>
            </ul>
            <ul class="header-nav ms-3">
                <li class="nav-item dropdown"><a class="nav-link py-0" data-coreui-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    <div class="avatar avatar-md"><i class="icon icon-2xl cil-mood-very-good"></i></div>
                </a>
                    <div class="dropdown-menu dropdown-menu-end pt-0">
                        <div class="dropdown-header bg-light py-2">
                            <div class="fw-semibold">Account</div>
                        </div><a class="dropdown-item" href="">
                        <i class="icon icon-2xl cil-arrow-thick-top"></i> Updates<span class="badge badge-sm bg-info ms-2">1</span></a><a class="dropdown-item" href="">
                        <i class="icon icon-2xl cil-envelope-closed"></i> Messages<span class="badge badge-sm bg-success ms-2">2</span></a><a class="dropdown-item" href="">
                        <i class="icon icon-2xl cil-task"></i> Tasks<span class="badge badge-sm bg-danger ms-2">3</span></a><a class="dropdown-item" href="">
                        <i class="icon icon-2xl cil-comment-bubble"></i> Comments<span class="badge badge-sm bg-warning ms-2">4</span></a>
                        <div class="dropdown-header bg-light py-2">
                            <div class="fw-semibold">Settings</div>
                        </div><a class="dropdown-item" href="">
                        <i class="icon icon-2xl cil-zoom"></i> Profile</a><a class="dropdown-item" href="">
                        <i class="icon icon-2xl cil-asterisk"></i> Settings</a><a class="dropdown-item" href="">
                        <i class="icon icon-2xl cil-money"></i> Payments<span class="badge badge-sm bg-secondary ms-2">5</span></a><a class="dropdown-item" href="">
                        <i class="icon icon-2xl cil-monitor"></i> Projects<span class="badge badge-sm bg-primary ms-2">6</span></a>
                        <div class="dropdown-divider"></div><a class="dropdown-item" href="">
                        <i class="icon icon-2xl cil-lock-locked"></i> Lock Account</a>

                        <a class="dropdown-item" href="/logout">
                            <i class="icon icon-2xl cil-power-standby"></i> Logout</a>
                    </div>
                </li>
            </ul>
        </div>
        <div class="header-divider"></div>
        <div class="container-fluid">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb my-0 ms-2">
                    <li class="breadcrumb-item">
                        <!-- if breadcrumb is single--><span>회원 관리</span>
                    </li>
                    <%--                    <li class="breadcrumb-item active"><span>Dashboard</span></li>--%>
                </ol>
            </nav>
        </div>
    </header>
    <div class="body flex-grow-1 px-3">
        <div class="row">
            <div class="card">
                <div class="card-header">
                    회원 목록
                </div>
                <div class="card-body">
                    <table id="test-datatable" class="table table-bordered">
                        <thead>
                        <tr>
                            <th scope="col">아이디</th>
                            <th scope="col">권한</th>
                            <th scope="col">활성화</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                    <button class="btn btn-lg btn-outline-light mt-3" type="button" onclick="location.href='/admin/adminpage'" style="background-color: gray">뒤로가기</button>
                </div>
            </div>
        </div>
        <!-- /.row-->
    </div>
</div>
<!-- CoreUI and necessary plugins-->
<script src="/js/coreui/coreui.bundle.min.js"></script>
<script src="/js/coreui/simplebar.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready( function () {
        $('#test-datatable').DataTable({
            ajax:{
                url:"/admin/getMembers",
                dataSrc:'data',
                type:'get'
            },
            columns:[
                {data:"name"}
                ,{data:"authority"}
                ,{data:"enabled"}
            ]
            ,order: [ [ 1, "asc" ] ]
            ,columnDefs: [
                { targets: [0,2], width: 100 }
            ]
            ,language: {
                emptyTable: "데이터가 없습니다.",
                lengthMenu: "페이지당 _MENU_ 개씩 보기",
                info: "현재 _START_ - _END_ / _TOTAL_건",
                infoEmpty: "데이터 없음",
                infoFiltered: "( _MAX_건의 데이터에서 필터링됨 )",
                search: "",
                zeroRecords: "일치하는 데이터가 없습니다.",
                loadingRecords: "로딩중...",
                processing: "잠시만 기다려 주세요.",
                paginate: {
                    next: "다음",
                    previous: "이전",
                },
            }
        })
    } );
</script>
</body>
</html>