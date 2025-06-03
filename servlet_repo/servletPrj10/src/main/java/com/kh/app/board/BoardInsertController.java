package com.kh.app.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet {
	//게시글 작성 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);
	}
	//게시글 작성 (로직)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//data
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		//service
		int result = 1; //서비스.insert(데이터); 
		//result
		if(result != 1) {
			req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
			return;
		}
		req.getRequestDispatcher("/WEB-INF/views/board/insertSuccess.jsp").forward(req, resp);
	}
}
