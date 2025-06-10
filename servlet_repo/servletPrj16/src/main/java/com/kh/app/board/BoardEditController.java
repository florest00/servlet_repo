package com.kh.app.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/edit")
public class BoardEditController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			req.setCharacterEncoding("UTF-8");
			//data
			String no = req.getParameter("no");
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			//data 뭉치기
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			
			//service
			BoardService boardService = new BoardService();
			int result = boardService.edit(vo);
			
//			System.out.println(result);
			PrintWriter out = resp.getWriter();
			out.write("result :" + result);
			
//			if(result == 1) {
//			}
			
			//result
//			resp.sendRedirect("/app/board/detail?no=7");
			resp.sendRedirect("/app/board/detail?no=" + no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
}
