<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/css/common.css">
</head>
<body>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main>
	<h1>게시글 목록</h1>
	<button onclick="location.href='/board/insert'">글 작성</button>
	</main>
	
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>