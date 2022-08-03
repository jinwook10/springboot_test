<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>CKEditor 5 ClassicEditor build</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/ckeditor/css/styles.css">
</head>
<body>
<form action="/write" method="post" enctype="multipart/form-data">
    제목
    <input id="title" type="text" name="title" placeholder="제목을 입력하세요">
    작성자<input type="text" name="writer" value="${user}" disabled>
    <textarea name="content" id="editor"></textarea>
    <input type="file" multiple="multiple" name="file">
    <input type="submit" value="글 작성">
</form>
</div>
<script src="/js/ckeditor/ckeditor.js"></script>
<script>ClassicEditor
    .create(document.querySelector('#editor'), {
        licenseKey: '',
        toolbar: {
            items: [
                'heading',
                '|',
                'bold',
                'italic',
                'link',
                'bulletedList',
                'numberedList',
                '|',
                'outdent',
                'indent',
                '|',
                'blockQuote',
                'imageUpload',
                'insertTable',
                'mediaEmbed',
                'undo',
                'redo'
            ]
        },
        language: 'ko',
        image: {
            toolbar: [
                'imageTextAlternative',
                'imageStyle:inline',
                'imageStyle:block',
                'imageStyle:side'
            ]
        },
        table: {
            contentToolbar: [
                'tableColumn',
                'tableRow',
                'mergeTableCells'
            ]
        }
    })
    .then(editor => {
        window.editor = editor;
    })
    .catch(error => {
        console.error('Oops, something went wrong!');
        console.error('Please, report the following error on https://github.com/ckeditor/ckeditor5/issues with the build id and the error stack trace:');
        console.warn('Build id: frec71zatvdq-nohdljl880ze');
        console.error(error);
    });

</script>
</body>
</html>
