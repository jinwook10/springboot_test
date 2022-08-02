<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <title>Title</title>
</head>
<body>
<b1>회원가입</b1>
<div class="signupbox">
  <form method="post" action="/signup">
    <div class="mb-3">
      <label for="loginId" class="form-label">Id</label>
      <input type="text" class="form-control" id="loginId" name="username">
    </div>
    <div class="mb-3">
      <label for="loginPassword" class="form-label">Password</label>
      <input type="password" class="form-control" id="loginPassword" name="password">
    </div>

    <button type="submit" class="btn btn-primary">회원 가입</button>
    </br>

  </form>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
