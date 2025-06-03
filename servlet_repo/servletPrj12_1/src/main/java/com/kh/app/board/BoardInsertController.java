package com.kh.app.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/board/insert")
public class BoardInsertController extends HttpServlet {
	// 게시글 작성 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);
	}
	// 게시글 작성 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//data
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardVo vo = new BoardVo();
		
		//service
		BoardService boardService = new BoardService();
		int result = 0;
		try {
			result = boardService.insert(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // title, content 따로 하면 번거로우니까 vo로 객체 뭉치기
		
		//result
		if(result != 1) {
//			req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
			resp.sendRedirect("/app/error");
			return;
		}
//		req.getRequestDispatcher("/WEB-INF/views/board/insertSuccess.jsp").forward(req, resp);
		// 포워딩 같은 경우, 주소창이 그대로 남아서 리다이렉팅 권장
		resp.sendRedirect("/app/board/list");
	}
}
