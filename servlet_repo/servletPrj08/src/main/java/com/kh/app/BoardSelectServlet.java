package com.kh.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/board")
public class BoardSelectServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// data : 게시글 번호
		String bno = req.getParameter("bno");
		// 디비가서 select
		BoardVo vo = new BoardVo("1", "제목01", "내용01");
		
		// result : 게시글에 대한 데이터 보여주기
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(req, resp);
	}
}
