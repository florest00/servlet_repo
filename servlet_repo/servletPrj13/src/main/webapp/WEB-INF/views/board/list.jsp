<%@page import="com.kh.app.board.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<main>
		<h1>게시글 목록</h1>
		<button onclick="location.href = '/app/board/insert'">글작성</button>
		
		
		<hr>
		전체 게시글 갯수 : ${voList.size()}
		<c:forEach var="vo" items="${voList}">
			<h2>${vo}</h2>
		</c:forEach>
		
		<c:if test="%{ voList.size() > 0}">
			<h1>게시글이 없습니다.</h1>
		</c:if>
		
		<% 
			/* List<BoardVo> voList = (List<BoardVo>) request.getAttribute("voList");
			for(BoardVo vo : voList) {
				out.write("<h3>");
				out.write(vo.toString());
				out.write("</h3>");
			} */
		%>

		
		<%-- <h3>${voList[0]}</h3>
		<h3>${voList[1]}</h3>
		<h3>${voList[2]}</h3>
		<h3>${voList[3]}</h3>
		<h3>${voList[4]}</h3> --%>
		
		
		
		
	</main>

</body>
</html>