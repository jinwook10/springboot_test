<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <link rel="stylesheet" href="/css/coreui/coreui.min.css">
  <title>Title</title>
</head>
<body>
<div class="bg-light min-vh-100 d-flex flex-row align-items-center">
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card mb-4 mx-4">
          <form method="post" action="/signup">
          <div class="card-body p-4">
            <h1 style="color: black">회원 가입</h1>
            <br>
            <div class="input-group mb-3"><span class="input-group-text">
              <input class="form-control" type="text" placeholder="Username" name="username">
            </div>

            <div class="input-group mb-3"><span class="input-group-text">
              <input class="form-control" type="password" placeholder="Password" name="password">
            </div>

            <button class="btn btn-block btn-success" type="submit">회원 가입</button>
            <button class="btn btn-block btn-success" type="button" onclick="location.href='/login'" style="background-color: gray">뒤로 가기</button>
          </div>
          </form>
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
