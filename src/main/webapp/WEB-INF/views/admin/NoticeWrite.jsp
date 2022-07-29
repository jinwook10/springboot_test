<%--
  Created by IntelliJ IDEA.
  User: cyder
  Date: 2022-07-28
  Time: 오전 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>공지사항</title>
</head>
<style>
    .ck-editor__editable { height: 400px; }
</style>
<body>
<h1>CKEditor5 테스트</h1>
<form action="/writhupload" method="POST">
    <textarea name="text" id="editor"></textarea>
    <p><input type="submit" value="전송"></p>
</form>
<script src="https://cdn.ckeditor.com/ckeditor5/34.2.0/classic/ckeditor.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
<script>
    ClassicEditor.create(document.querySelector("#editor"),
        {
            language: "ko",
            simpleUpload:
                {
                    uploadUrl: "/upload/image",
                    withCredentials: true,
                }
        })
        .then(newEditor => {
            editor = newEditor;
        })
        .catch(error => {
            console.error(error);
        });
</script>
</body>
</html>
