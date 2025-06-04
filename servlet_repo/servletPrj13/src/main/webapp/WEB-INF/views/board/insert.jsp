<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main>
		<h1>게시글 작성</h1>
		
		<form action="/app/board/insert" method="post">
		<input type="text" name="title" placeholder="제목">
		<br>
		<textarea name="content" placeholder="내용"></textarea>
		<br>
		<input type="submit" value="게시글 작성">
	</form>
	</main>
	
</body>
</html>