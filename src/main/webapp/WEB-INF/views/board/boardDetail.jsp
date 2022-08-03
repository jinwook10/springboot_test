<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>CKEditor 5 ClassicEditor build</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
<div class="mb-3">
    <label for="exampleFormControlInput1" class="form-label">제목</label>
    <input type="email" class="form-control" id="exampleFormControlInput1" value="${bd.title}" disabled>
</div>
<div class="mb-3">
    <label for="exampleFormControlInput2" class="form-label">작성자</label>
    <input type="email" class="form-control" id="exampleFormControlInput2" value="${bd.writer}" disabled>
</div>
<div class="mb-3">
    <label for="exampleFormControlInput3" class="form-label">작성일</label>
    <input type="email" class="form-control" id="exampleFormControlInput3" value="${bd.write_time}" disabled>
</div>
<div class="mb-3">
    <label for="exampleFormControlInput4" class="form-label">수정일</label>
    <input type="email" class="form-control" id="exampleFormControlInput4" value="${bd.update_time}" disabled>
</div>
<div class="mb-3">
    <label for="exampleFormControlTextarea1" class="form-label">내용</label>
    <div class="form-control" id="exampleFormControlTextarea1"  disabled>
        ${bd.content}
    </div>
</div>
<div class="mb-3">
    <label class="form-label">첨부파일</label>
    <a href="/filedown?no=${f}">다운로드
<%--        ${f.no}--%>
</div>
</body>
</html>
