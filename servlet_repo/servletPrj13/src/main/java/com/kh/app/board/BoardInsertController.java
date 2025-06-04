package com.kh.app.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/board/*")
public class BoardInsertController extends HttpServlet {
	//ghkaus
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);
	}
	//logic
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			//data
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			System.out.println("title : " + title);
			System.out.println("content : " + content);
			
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContent(content);
			
			//service
			BoardService boardService = new BoardService();
			int result = boardService.insert(vo);
			
			//result
			resp.sendRedirect("/app/board/list");
		} catch (Exception e) {
			e.printStackTrace(); // 서버/관리자가 어떤 에러가 났는지 알 수 있게
			resp.sendRedirect("/app/error"); // 유저한테는 단순 에러났다는 페이지만
		}
	}
}
