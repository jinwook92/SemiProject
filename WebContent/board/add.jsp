<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
</head>
<body>
<form method="post" action="addresult.do" enctype="multipart/form-data">
    <ul>
        <li>
            <label for="title">제목</label><input type="text" id="title" name="title">
        </li>
        <li><label for="content">내용</label></li>
        <li>
            <textarea rows="4" cols="50" id="content" name="content"></textarea>
        </li>
        <li><label for="fname">파일추가</label>
            <input type="file" name="fname" id="fname">
        <li>
            <input type="submit" value="전송"><input type="reset" value="취소">
        </li>
    </ul>
</form>


</body>
</html>