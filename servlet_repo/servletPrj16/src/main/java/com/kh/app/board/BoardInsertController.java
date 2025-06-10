package com.kh.app.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet {
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.getRequestDispatcher("/WEB-INF/views/board")
//	
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			
			// 데이터 받아오기
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			// 데이터 뭉쳐주기
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContent(content);
			
			//service 호출
			BoardService boardService = new BoardService();
			int result = boardService.insert(vo);
			if(result != 1) {
				throw new IllegalStateException();
			}

			
			System.out.println("***********");
			System.out.println(result);
			
//			resp.sendRedirect("/app/board/list");
			PrintWriter out = resp.getWriter();
			out.write("result : " + result);
//			키/밸류 값 구분하려고 
			//result 
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/app/error");
		}
	
	}
	
	
}
