
<%@page import="java.util.List"%>
<%@page import="com.kh.app.board.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 목록</h1>
	
	<% List<BoardVo> voList = (List) request.getAttribute("voList"); %>
	<% for(BoardVo vo : voList) { %>
	<h2><%= vo.getContent() %></h2>
	<% } %>
	
</body>
</html>