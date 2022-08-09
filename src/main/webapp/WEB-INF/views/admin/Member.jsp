<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.js"
            integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css"/>
    <meta charset="UTF-8">
    <title>회원관리 페이지</title>
</head>
<body>

<table id="test-datatable">
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
<a href="/admin/adminpage">뒤로가기</a>
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
            , lengthChange: false
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
<script type="text/javascript" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
</body>
</html>